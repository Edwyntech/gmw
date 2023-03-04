package tech.edwyn.gmw.domain.model;

import java.util.List;

public record Quiz(Long id, List<QuestionWithAnswers> questionWithAnswers) {
}
