package tech.edwyn.gmw.domain.model;

import java.util.List;

public record Quiz(Question question, List<Answer> answers) {
}
