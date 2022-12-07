package tech.edwyn.gmw.domain.model;

public interface Answer {
    Long getId();

    AnswerType getType();

    Object getValue();
}
