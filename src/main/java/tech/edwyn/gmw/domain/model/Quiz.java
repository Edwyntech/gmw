package tech.edwyn.gmw.domain.model;

import lombok.Builder;

import java.util.List;

@Builder
public record Quiz(Long id, String name, List<QuestionWithAnswers> questionWithAnswers) {
}
