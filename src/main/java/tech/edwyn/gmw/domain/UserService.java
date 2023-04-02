package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

@RequiredArgsConstructor
public class UserService implements UserHandlerApi {
    private final UserStoreSpi userStoreSpi;

    @Override
    public User add(String firstName, String lastName, String email) {
        return userStoreSpi.add(firstName, lastName, email);
    }

    @Override
    public Boolean hasAlreadyName(String email) {
        return userStoreSpi.hasAlreadyEmail(email);
    }

    @Override
    public Integer getScore(String name) {
        return userStoreSpi.getScore(name);
    }
}
