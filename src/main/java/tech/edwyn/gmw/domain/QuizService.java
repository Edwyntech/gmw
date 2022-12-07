package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

import java.util.List;

@RequiredArgsConstructor
public class QuizService implements QuizHandlerApi {
    private final QuizStoreSpi quizStore;

    @Override
    public List<Quiz> getAllForUser(Long userId) {
        return quizStore.getAll();
    }

    @Override
    public Boolean verifyAnswer(Long questionId, Long answerId) {
        return quizStore.isAnswerCorrect(questionId, answerId);
    }

}
