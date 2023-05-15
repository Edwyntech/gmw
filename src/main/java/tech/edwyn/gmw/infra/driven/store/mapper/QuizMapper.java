package tech.edwyn.gmw.infra.driven.store.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.edwyn.gmw.domain.model.QuestionWithAnswers;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;
import tech.edwyn.gmw.infra.driven.store.entity.QuizEntity;

import java.util.Comparator;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuizMapper {

    public static Quiz toDomain(QuizEntity quizEntity) {
        return Quiz.builder()
                .id(quizEntity.getId())
                .description(quizEntity.getName())
                .questionWithAnswers(quizEntity.getQuestions().stream()
                        .map(questionEntity -> QuestionWithAnswers.builder()
                                .question(QuestionMapper.toDomain(questionEntity))
                                .answers(questionEntity.getAnswers().stream()
                                        .sorted(Comparator.comparing(AnswerEntity::getId))
                                        .map(AnswerMapper::toDomain)
                                        .toList())
                                .build())
                        .toList())
                .build();
    }

    public static QuizEntity toEntity(Quiz quiz) {
        return  QuizEntity.builder()
                .id(quiz.id())
                .name(quiz.description())
                .questions(quiz.questionWithAnswers().stream()
                        .map(questionWithAnswers -> QuestionMapper.toEntity(questionWithAnswers.question()))
                        .collect(Collectors.toSet()))
                .build();
    }

}
