package tech.edwyn.gmw.domain.model;

import java.util.Optional;

public interface Question {
    Long getId();

    QuestionType getType();

    Object getValue();

    Optional<String> getImageUrl();
}
