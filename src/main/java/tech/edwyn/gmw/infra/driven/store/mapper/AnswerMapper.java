package tech.edwyn.gmw.infra.driven.store.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.edwyn.gmw.domain.model.Answer;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswerMapper {

    public static Answer toDomain(AnswerEntity entity) {
        return Answer.builder()
                .id(entity.getId())
                .correct(entity.getCorrect())
                .value(entity.getText())
                .imageUrl(Optional.ofNullable(entity.getImageUrl()))
                .build();
    }

    public static AnswerEntity toEntity(Answer answer) {
        return AnswerEntity.builder()
                .id(answer.id())
                .correct(answer.correct())
                .text(answer.value())
                .imageUrl(answer.imageUrl().get())
                .build();
    }

}
