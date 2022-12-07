package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.model.TextAnswer;
import tech.edwyn.gmw.domain.model.TextQuestion;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuestionRepository questionRepository;

    @Override
    public List<Quiz> getAll() {
        return questionRepository.findAll().stream()
                .map(question -> new Quiz(
                        new TextQuestion(question.getId(), question.getText()),
                        question.getAnswers().stream()
                                .map(answer -> new TextAnswer(answer.getId(), answer.getText()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean isAnswerCorrect(Long questionId, Long answerId) {
        return questionRepository.findById(questionId)
                .map(question -> question.getAnswers().stream()
                        .filter(answer -> answer.getId().equals(answerId)).findFirst().map(Answer::getCorrect).orElse(false))
                .orElse(false);
    }
}
