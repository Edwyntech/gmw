
package tech.edwyn.gmw.domain.store;

import tech.edwyn.gmw.domain.model.Quiz;

import java.util.List;

// driven
public interface QuizStoreSpi {
    Quiz save(Quiz quiz);

    List<Quiz> getAll();

    Quiz getQuiz(Long id);

    void delete(Long id);
}
