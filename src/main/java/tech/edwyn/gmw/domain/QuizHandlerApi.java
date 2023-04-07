package tech.edwyn.gmw.domain;

import tech.edwyn.gmw.domain.model.Quiz;

import java.util.List;

//driving
public interface QuizHandlerApi {
    Quiz createQuiz(Quiz quiz);

    List<Quiz> getAllQuizzes();

    Quiz getDefaultQuiz();

    Quiz getQuiz(Long quizId);

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long quizId);

    Boolean verifyAnswer(Long questionId, Long answerId, String email);
}
