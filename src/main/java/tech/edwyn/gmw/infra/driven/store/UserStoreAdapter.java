package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driven.store.mapper.UserMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuestionRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class UserStoreAdapter implements UserStoreSpi {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

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
    public Integer getScore(String email) {
        return userRepository.findByEmail(email)
                .map(user -> user.getUserCorrectQuestions().size())
                .orElse(0);
    }
}
