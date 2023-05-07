package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.domain.model.Score;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driven.store.exception.GMWException;
import tech.edwyn.gmw.infra.driven.store.mapper.UserMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuestionRepository;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

import java.util.List;

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
        Integer scoreValue = userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectQuestions().size())
                .orElse(0);

        int maxScore = getMaxScore(quizId);
        return Score.builder()
                .score(scoreValue)
                .maxScore(maxScore)
                .text(null)
                .build();
    }

    @Override
    public List<Question> getSuccessfullyQuestions(String email, Long quizId) {

        return userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectQuestions()
                ).orElseThrow().stream().
                map(QuestionMapper::toDomain).toList();
    }

    private int getMaxScore(Long quizId) {
        int maxScore = quizRepository.findById(quizId).
                orElseThrow(() -> new GMWException("Quiz not found")).getQuestions().size();
        return maxScore;
    }
}
