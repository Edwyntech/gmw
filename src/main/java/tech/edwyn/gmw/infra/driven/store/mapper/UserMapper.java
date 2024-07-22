package tech.edwyn.gmw.infra.driven.store.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.infra.driven.store.entity.UserEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static User toDomain(UserEntity entity) {
        return new User(entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }

    public static UserEntity toEntity(String firstName, String lastName, String email) {
        var user =  new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }
}
