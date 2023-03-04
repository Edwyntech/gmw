
package tech.edwyn.gmw.domain.store;

import tech.edwyn.gmw.domain.model.Quiz;

import java.util.List;

// driven
public interface QuizStoreSpi {
    List<Quiz> getAll();

    Quiz getDefaultQuiz();

    Quiz getQuiz(Long id);
}
