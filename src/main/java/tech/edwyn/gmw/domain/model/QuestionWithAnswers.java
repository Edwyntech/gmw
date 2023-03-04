package tech.edwyn.gmw.domain.model;

import java.util.List;

public record QuestionWithAnswers(Question question, List<Answer> answers) {
}
