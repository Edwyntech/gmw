package tech.edwyn.gmw.domain;

public interface Question<T> {
    QuestionType getType();

    T getValue();
}
