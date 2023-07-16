package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.domain.model.Score;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driven.store.entity.*;
import tech.edwyn.gmw.infra.driven.store.exception.GMWException;
import tech.edwyn.gmw.infra.driven.store.mapper.UserMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuestionRepository;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserCorrectAnswerRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class UserStoreAdapter implements UserStoreSpi {
    private final UserRepository userRepository;
    private final UserCorrectAnswerRepository userCorrectAnswerRepository;
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    @Override
    public User add(String firstName, String lastName, String email) {
        var user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, format("User email %s already exists", email));
        }
        return UserMapper.toDomain(userRepository.save(UserMapper.toEntity(firstName, lastName, email)));
    }

    @Override
    public Boolean hasAlreadyEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void addCorrectQuestion(String email, Long questionId) {
        questionRepository.findById(questionId)
                .ifPresent(question -> userRepository.findByEmail(email)
                        .ifPresent(user -> {
                            var userCorrectAnswer = new UserCorrectAnswerEntity(new UserCorrectAnswerId(), user, question, new Date(Instant.now().toEpochMilli()));
                            user.getUserCorrectAnswers().add(userCorrectAnswer);
                            question.getUserCorrectAnswers().add(userCorrectAnswer);
                            userCorrectAnswerRepository.save(userCorrectAnswer);
                        })
                );
    }

    @Override
    public Score getScore(String email, Long quizId) {
        var scoreValue = userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectAnswers().stream()
                        .filter(correctQuestion -> correctQuestion.getQuestion().getQuiz().getId().equals(quizId)).toList()
                        .size())
                .orElse(0);
        var maxScore = getMaxScore(quizId);
        var text = "Merci d'avoir participé au questionnaire, nous te tiendrons informés du résultat de tirage au sort pour déterminer les deux gagnants!";
        return Score.builder()
                .score(scoreValue)
                .maxScore(maxScore)
                .text(text)
                .build();
    }

    @Override
    public List<Question> getSuccessfullyQuestions(String email, Long quizId) {

        return userRepository.findByEmail(email)
                .map(UserEntity::getUserCorrectAnswers)
                .map(uca -> uca.stream().map(UserCorrectAnswerEntity::getQuestion).collect(Collectors.toList()))
                .map(q -> q.stream().map(QuestionMapper::toDomain).collect(Collectors.toList()))
                .get();
    }

    @Override
    public List<Long> getCompletedQuizIds(String email) {
        return userRepository.findByEmail(email)
                .map(UserEntity::getUserCorrectAnswers)
                .map(uca -> uca.stream().map(UserCorrectAnswerEntity::getQuestion).collect(Collectors.toList()))
                .map(q -> q.stream().map(qu -> qu.getQuiz().getId()).collect(Collectors.toList()))
                .stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }

    private int getMaxScore(Long quizId) {
        return quizRepository
                .findById(quizId)
                .orElseThrow(() -> new GMWException("Quiz not found")).getQuestions().size();
    }
}
