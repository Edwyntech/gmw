package tech.edwyn.gmw.infra.driven.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edwyn.gmw.infra.driven.store.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
}
