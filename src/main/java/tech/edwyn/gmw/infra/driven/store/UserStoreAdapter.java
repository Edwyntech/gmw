package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driven.store.mapper.UserMapper;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserStoreAdapter implements UserStoreSpi {
    private final UserRepository userRepository;

    @Override
    public User add(String name) {
        return UserMapper.toDomain(userRepository.save(UserMapper.toEntity(name)));
    }

    @Override
    public Boolean hasAlreadyName(String name) {
        return userRepository.findByName(name).isPresent();
    }
}
