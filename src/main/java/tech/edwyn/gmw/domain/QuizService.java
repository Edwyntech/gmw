package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.domain.store.UserStoreSpi;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuizService implements QuizHandlerApi {
    private final QuizStoreSpi quizStore;
    private final AnswerStoreSpi answerStoreSpi;
    private final UserStoreSpi userStoreSpi;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizStore.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuizzes(String email) {
        var quizzes = quizStore.getAll();
        var completedQuizzesIds = userStoreSpi.getCompletedQuizzes(email).stream().map(Quiz::id).toList();

        return quizzes.stream()
                .map(q -> new Quiz(q.id(), q.description(), completedQuizzesIds.contains(q.id()), q.questionWithAnswers()))
                .collect(Collectors.toList());
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
    public Quiz updateQuiz(Quiz quiz) {
        var quizFound = quizStore.getQuiz(quiz.id());

        if (quizFound == null) throw new QuizNotFoundException("Quiz not found");

        quizFound.toBuilder()
                .name(quiz.name())
                .questionWithAnswers(quiz.questionWithAnswers())
                .build();

        return quizStore.save(quizFound);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        var quizFound = quizStore.getQuiz(quizId);

        if (quizFound == null) throw new QuizNotFoundException("Quiz not found");

        quizStore.delete(quizId);
    }

    @Override
    public Boolean verifyAnswer(Long questionId, Long answerId, String email) {
        var isCorrectAnswer = answerStoreSpi.findIsCorrectByQuestionId(questionId, answerId);

        if (isCorrectAnswer) {
            userStoreSpi.addCorrectQuestion(email, questionId);
        }

        return isCorrectAnswer;
    }


}
