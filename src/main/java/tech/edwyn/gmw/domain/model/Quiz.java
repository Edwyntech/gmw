package tech.edwyn.gmw.domain.model;

import java.util.List;

public record Quiz(Long id, String description, Boolean done, List<QuestionWithAnswers> questionWithAnswers) {
}
