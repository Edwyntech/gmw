package tech.edwyn.gmw.domain.model;

import lombok.Builder;

import java.util.Optional;

@Builder
public record Answer(Long id, Boolean correct, String value, Optional<String> imageUrl) { }
