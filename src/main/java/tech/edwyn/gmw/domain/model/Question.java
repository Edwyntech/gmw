package tech.edwyn.gmw.domain.model;

import java.util.Optional;

public record Question(Long id, String value, String imageUrl) {
    public Optional<String> getImageUrl() {
        return Optional.ofNullable(imageUrl);
    }
}
