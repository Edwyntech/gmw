
package tech.edwyn.gmw.domain.store;

import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.model.Score;
import tech.edwyn.gmw.domain.model.User;

import java.util.List;

// driven
public interface UserStoreSpi {
    User add(String firstName, String lastName, String email);

    Boolean hasAlreadyEmail(String email);

    void addCorrectQuestion(String email, Long questionId);

    Score getScore(String email, Long quizId);

    List<Question> getSuccessfullyQuestions(String email, Long quizId);

    List<Long> getCompletedQuizIds(String email);
}
