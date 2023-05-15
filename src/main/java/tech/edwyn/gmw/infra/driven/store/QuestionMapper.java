package tech.edwyn.gmw.infra.driven.store;

import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.infra.driven.store.entity.QuestionEntity;

import java.util.Optional;

public class QuestionMapper {
    public static Question toDomain(QuestionEntity questionEntity) {
        return Question.builder()
                .id(questionEntity.getId())
                .value(questionEntity.getText())
                .imageUrl(Optional.ofNullable(questionEntity.getImageUrl()))
                .build();
    }
}
