package tech.edwyn.gmw.infra.driven.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
    List<AnswerEntity> findByQuestionId(Long questionId);
}
