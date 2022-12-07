package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

import java.util.List;

@RequiredArgsConstructor
public class QuizService implements QuizHandlerApi { // todo name Quiz
    private final QuizStoreSpi quizStore;
    private final AnswerStoreSpi answerStoreSpi;

    @Override
    public List<Quiz> getAllQuizzesForUser(Long userId) {
        return quizStore.getAllQuizzes();
    }

    @Override
    public Boolean verifyAnswer(Long questionId, Long answerId) {
        return answerStoreSpi.findIsCorrectByQuestionId(questionId, answerId);
    }
}
