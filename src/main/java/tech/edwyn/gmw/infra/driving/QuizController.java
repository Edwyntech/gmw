package tech.edwyn.gmw.infra.driving;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.QuizHandlerApi;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizHandlerApi quizHandler;

    @GetMapping
    public List<Quiz> getAll() {
        return quizHandler.getAllForUser(1); // TODO random id, will be replaced
    }
}
