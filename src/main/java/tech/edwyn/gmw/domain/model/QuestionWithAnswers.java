package tech.edwyn.gmw.domain.model;

import lombok.Builder;

import java.util.List;

@Builder
public record QuestionWithAnswers(Question question, List<Answer> answers) {
}
