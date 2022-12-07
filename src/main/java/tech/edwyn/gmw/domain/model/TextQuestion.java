package tech.edwyn.gmw.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextQuestion implements Question {

    private final Long id;
    private final String value;

    @Override
    public QuestionType getType() {
        return QuestionType.TEXT;
    }
}
