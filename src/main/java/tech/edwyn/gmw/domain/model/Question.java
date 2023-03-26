package tech.edwyn.gmw.domain.model;

import lombok.Builder;

import java.util.Optional;

@Builder
public record Question(Long id, String value, Optional<String> imageUrl) {
}
