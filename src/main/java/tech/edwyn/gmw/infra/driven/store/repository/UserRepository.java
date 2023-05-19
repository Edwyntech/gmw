package tech.edwyn.gmw.infra.driven.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edwyn.gmw.infra.driven.store.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
