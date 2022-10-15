package tech.edwyn.gmw.domain;

public interface Answer<T> {
    AnswerType getType();

    T getValue();
}
