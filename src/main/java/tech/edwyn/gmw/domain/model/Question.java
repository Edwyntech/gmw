package tech.edwyn.gmw.domain.model;

import java.util.Optional;

public record Question(Long id, String value, Optional<String> imageUrl) {
}
