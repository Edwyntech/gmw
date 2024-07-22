package tech.edwyn.gmw.domain.model;

import lombok.Builder;

@Builder
public record Score(String text, Integer score, Integer maxScore) { }
