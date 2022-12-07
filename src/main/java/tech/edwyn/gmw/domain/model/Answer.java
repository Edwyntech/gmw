package tech.edwyn.gmw.domain.model;

import java.util.Optional;

public record Answer(Long id, String value, Optional<String> imageUrl) {
}
