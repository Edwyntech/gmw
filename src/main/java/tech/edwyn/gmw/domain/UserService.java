package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

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

    @Override
    public Integer getScore(String name) {
        return userStoreSpi.getScore(name);
    }
}
