package tech.edwyn.gmw.infra.driving;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.edwyn.gmw.domain.QuizHandlerApi;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.infra.driving.model.CreateQuizRequest;
import tech.edwyn.gmw.infra.driving.model.UpdateQuizRequest;
import tech.edwyn.gmw.infra.driving.model.VerifyAnswerRequest;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {
    private final QuizHandlerApi quizHandler;

    @GetMapping("/user")
    public List<Quiz> getAll(@RequestParam String email) {
        return quizHandler.getAllQuizzes(email);
    }

    @PostMapping()
    public void createQuiz(@Valid @RequestBody CreateQuizRequest quiz) {
        quizHandler.createQuiz(quiz.toDomain());
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable Long quizId) {
        return quizHandler.getQuiz(quizId);
    }

    @PutMapping()
    public void updateQuiz(@Valid @RequestBody UpdateQuizRequest quiz) {
        quizHandler.updateQuiz(quiz.toDomain());
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable Long quizId) {
        quizHandler.deleteQuiz(quizId);
    }

    @PostMapping("/verify")
    public Boolean verifyAnswer(@RequestBody VerifyAnswerRequest request) {
        return quizHandler.verifyAnswer(request.getQuestionId(), request.getAnswerId(), request.getEmail());
    }

}
