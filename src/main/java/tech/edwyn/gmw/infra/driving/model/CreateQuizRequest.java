package tech.edwyn.gmw.infra.driving.model;

import lombok.Builder;
import lombok.Value;
import tech.edwyn.gmw.domain.model.QuestionWithAnswers;
import tech.edwyn.gmw.domain.model.Quiz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Value
@Builder
public class CreateQuizRequest {
    @NotEmpty(message = "Name may not be empty")
    String name;
    @NotNull(message = "Question with answers may not be empty")
    List<QuestionWithAnswers> questionWithAnswers;


    public Quiz toDomain() {
        return Quiz.builder()
                .description(name)
                .questionWithAnswers(questionWithAnswers)
                .build();
    }
}
