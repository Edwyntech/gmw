package tech.edwyn.gmw.infra.driving.model;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
public class VerifyAnswerRequest {
    @NotNull(message = "QuestionId may not be null")
    private Long questionId;
    @NotNull(message = "AnswerId may not be null")
    private Long answerId;
    @NotEmpty(message = "Email may not be empty")
    private String email;
}
