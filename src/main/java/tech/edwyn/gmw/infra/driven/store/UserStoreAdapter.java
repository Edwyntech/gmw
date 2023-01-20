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
    public User add(String name) {
        var user = userRepository.findByName(name);
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, format("User %s already exists", name));
        }
        return UserMapper.toDomain(userRepository.save(UserMapper.toEntity(name)));
    }

    @Override
    public Boolean hasAlreadyName(String name) {
        return userRepository.findByName(name).isPresent();
    }

    @Override
    public User addCorrectQuestion(String name, Long questionId) {
        var question = questionRepository.findById(questionId);
        return userRepository.findByName(name).map(user -> {
                            user.getUserCorrectQuestions().add(question.get());
                            return userRepository.save(user);
                        }
                )
                .map(UserMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public Integer getScore(String name) {
        return userRepository.findByName(name)
                .map(user -> user.getUserCorrectQuestions().size())
                .orElse(0);
    }
}
