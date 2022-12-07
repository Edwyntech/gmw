package tech.edwyn.gmw.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Answer;
import tech.edwyn.gmw.domain.model.AnswerType;

@Data
@RequiredArgsConstructor
public class TextAnswer implements Answer {

    private final Long id;
    private final String value;

    @Override
    public AnswerType getType() {
        return AnswerType.TEXT;
    }
}
