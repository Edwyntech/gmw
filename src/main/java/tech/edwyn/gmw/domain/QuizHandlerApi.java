package tech.edwyn.gmw.domain;

import tech.edwyn.gmw.domain.model.Quiz;

import java.util.List;

//driving
public interface QuizHandlerApi {
    List<Quiz> getAllQuizzesForUser(Long userId);

    Boolean verifyAnswer(Long questionId, Long answerId);
}
