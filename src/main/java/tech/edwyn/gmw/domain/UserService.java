package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

import java.util.List;

@RequiredArgsConstructor
public class UserService implements UserHandlerApi {
    private final UserStoreSpi userStoreSpi;

    @Override
    public User add(String name) {
        return userStoreSpi.add(name);
    }

    @Override
    public Boolean hasAlreadyName(String name) {
        return userStoreSpi.hasAlreadyName(name);
    }
}
