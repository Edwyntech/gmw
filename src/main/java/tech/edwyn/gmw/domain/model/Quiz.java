package tech.edwyn.gmw.domain.model;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Quiz(Long id, String description, Boolean done, List<QuestionWithAnswers> questionWithAnswers) {
}
