package tech.edwyn.gmw.infra.driven.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edwyn.gmw.infra.driven.store.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
