package tech.edwyn.gmw.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.domain.model.QuestionType;

@Data
@RequiredArgsConstructor
public class TextQuestion implements Question {

    private final Integer id;
    private final String value;

    @Override
    public QuestionType getType() {
        return QuestionType.TEXT;
    }
}
