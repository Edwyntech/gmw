package tech.edwyn.gmw.domain;

import tech.edwyn.gmw.domain.model.Quiz;

import java.util.List;

//driving
public interface QuizHandlerApi {
    List<Quiz> getAllQuizzes();

    Quiz getDefaultQuiz();

    Quiz getQuiz(Long quizId);

    Boolean verifyAnswer(Long questionId, Long answerId, String email);
}
