package tech.edwyn.gmw.infra.driving.model;

import lombok.Data;

@Data
public class VerifyAnswerRequest {
    private Long questionId;
    private Long answerId;
}
