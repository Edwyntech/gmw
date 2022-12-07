package tech.edwyn.gmw.infra.driven.store.mapper;

import tech.edwyn.gmw.domain.model.Answer;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;
import tech.edwyn.gmw.infra.driven.store.entity.QuestionEntity;

import java.util.Optional;

public class QuizMapper {
    public static Question toDomain(QuestionEntity entity) {
        return new Question(
                entity.getId(),
                entity.getText(),
                Optional.ofNullable(entity.getImageUrl()));
    }

    public static Answer toDomain(AnswerEntity entity) {
        return new Answer(
                entity.getId(),
                entity.getText(),
                Optional.ofNullable(entity.getImageUrl()));
    }
}
