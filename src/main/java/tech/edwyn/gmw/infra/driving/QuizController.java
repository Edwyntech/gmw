package tech.edwyn.gmw.infra.driving;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.QuizHandlerApi;
import tech.edwyn.gmw.infra.driving.model.VerifyAnswerRequest;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizHandlerApi quizHandler;

    @GetMapping
    public List<Quiz> getAll() {
        return quizHandler.getAllForUser(1L); // TODO random id, will be replaced
    }

    @PostMapping("/verify")
    public Boolean verifyAnswer(@RequestBody VerifyAnswerRequest request) {
        return quizHandler.verifyAnswer(request.getQuestionId(), request.getAnswerId());
    }
}
