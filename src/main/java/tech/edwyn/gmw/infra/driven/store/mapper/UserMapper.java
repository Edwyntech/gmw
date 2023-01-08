package tech.edwyn.gmw.infra.driven.store.mapper;

import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.infra.driven.store.entity.UserEntity;

public class UserMapper {
    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName());
    }

    public static UserEntity toEntity(String name) {
        return new UserEntity(null, name);
    }
}
