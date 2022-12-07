package tech.edwyn.gmw.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@RequiredArgsConstructor
public class TextQuestion implements Question {

    private final Long id;
    private final String value;
    private final String imageUrl;

    @Override
    public QuestionType getType() {
        return QuestionType.TEXT;
    }

    @Override
    public Optional<String> getImageUrl() {
        return Optional.ofNullable(imageUrl);
    }
}
