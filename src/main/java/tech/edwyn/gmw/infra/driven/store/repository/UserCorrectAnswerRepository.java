package tech.edwyn.gmw.infra.driven.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edwyn.gmw.infra.driven.store.entity.UserCorrectAnswerEntity;
import tech.edwyn.gmw.infra.driven.store.entity.UserCorrectAnswerId;

public interface UserCorrectAnswerRepository extends JpaRepository<UserCorrectAnswerEntity, UserCorrectAnswerId> {
}
