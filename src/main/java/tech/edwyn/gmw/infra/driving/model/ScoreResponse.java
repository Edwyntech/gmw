package tech.edwyn.gmw.infra.driving.model;

import lombok.Builder;

@Builder
public record ScoreResponse(String name, Integer score) {

}
