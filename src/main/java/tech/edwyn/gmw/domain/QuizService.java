package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

import java.util.List;

@RequiredArgsConstructor
public class QuizService implements QuizHandlerApi {
    private final QuizStoreSpi quizStore;
    private final AnswerStoreSpi answerStoreSpi;
    private final UserStoreSpi userStoreSpi;

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizStore.getAll();
    }

    @Override
    public Quiz getDefaultQuiz() {
        return quizStore.getDefaultQuiz();
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizStore.getQuiz(quizId);
    }

    @Override
    public Boolean verifyAnswer(Long questionId, Long answerId, String userName) {
        var isCorrectAnswer = answerStoreSpi.findIsCorrectByQuestionId(questionId, answerId);

        if (isCorrectAnswer) {
            userStoreSpi.addCorrectQuestion(userName, questionId);
        }

        return isCorrectAnswer;
    }


}
