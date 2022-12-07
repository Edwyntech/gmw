package tech.edwyn.gmw.domain.model;

public interface Question {
    Long getId();

    QuestionType getType();

    Object getValue();
}
