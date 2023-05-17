package tech.edwyn.gmw.infra.driven.store.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.infra.driven.store.entity.QuestionEntity;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionMapper {

    public static Question toDomain(QuestionEntity entity) {
        return Question.builder()
                .id(entity.getId())
                .value(entity.getText())
                .imageUrl(Optional.ofNullable(entity.getImageUrl()))
                .build();
    }

    public static QuestionEntity toEntity(Question question) {
        return QuestionEntity.builder()
                .id(question.id())
                .text(question.value())
                .imageUrl(question.imageUrl().orElse(null))
                .build();
    }

}
