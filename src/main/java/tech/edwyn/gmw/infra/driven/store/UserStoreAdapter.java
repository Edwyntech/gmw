package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.edwyn.gmw.domain.model.*;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;
import tech.edwyn.gmw.infra.driven.store.exception.GMWException;
import tech.edwyn.gmw.infra.driven.store.mapper.AnswerMapper;
import tech.edwyn.gmw.infra.driven.store.mapper.UserMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuestionRepository;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class UserStoreAdapter implements UserStoreSpi {
    private final UserRepository userRepository;
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
    public User addCorrectQuestion(String email, Long questionId) {
        var question = questionRepository.findById(questionId);
        return userRepository.findByEmail(email).map(user -> {
                            user.getUserCorrectQuestions().add(question.get());
                            return userRepository.save(user);
                        }
                )
                .map(UserMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public Score getScore(String email, Long quizId) {
        var scoreValue = userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectQuestions().stream()
                        .filter(correctQuestion -> correctQuestion.getQuiz().getId().equals(quizId)).toList()
                        .size())
                .orElse(0);
        var maxScore = getMaxScore(quizId);
        var scorePercentage = (double) scoreValue / maxScore;
        var text = scorePercentage > 0.5 ? "Bravo !": "";
        return Score.builder()
                .score(scoreValue)
                .maxScore(maxScore)
                .text(text)
                .build();
    }

    @Override
    public List<Question> getSuccessfullyQuestions(String email, Long quizId) {

        return userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectQuestions()
                ).orElseThrow().stream().
                map(QuestionMapper::toDomain).toList();
    }

    @Override
    public List<Quiz> getCompletedQuizzes(String email) {
        List<Quiz> quizzes = userRepository.findByEmail(email)
                .map(userEntity -> userEntity.getUserCorrectQuestions().stream()
                        .map(correctQuestion -> {
                            var quizEntity = correctQuestion.getQuiz();
                            return new Quiz(quizEntity.getId(), quizEntity.getName(), true, quizEntity.getQuestions().stream().map(questionEntity -> new QuestionWithAnswers(
                                    QuestionMapper.toDomain(questionEntity),
                                    questionEntity.getAnswers().stream()
                                            .sorted(Comparator.comparing(AnswerEntity::getId))
                                            .map(AnswerMapper::toDomain)
                                            .collect(Collectors.toList()))).collect(Collectors.toList()));
                        })
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return quizzes.stream().distinct().collect(Collectors.toList());
    }

    private int getMaxScore(Long quizId) {
        return quizRepository
                .findById(quizId)
                .orElseThrow(() -> new GMWException("Quiz not found")).getQuestions().size();
    }
}
