package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.model.Answer;
import tech.edwyn.gmw.domain.model.Question;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuestionRepository questionRepository;

    @Override
    public List<Quiz> getAll() {
        return questionRepository.findAll().stream()
                .sorted(Comparator.comparing(tech.edwyn.gmw.infra.driven.store.Question::getId))
                .map(question -> new Quiz(
                        new Question(question.getId(), question.getText(), question.getImageUrl()),
                        question.getAnswers().stream()
                                .sorted(Comparator.comparing(tech.edwyn.gmw.infra.driven.store.Answer::getId))
                                .map(answer -> new Answer(answer.getId(), answer.getText()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean isAnswerCorrect(Long questionId, Long answerId) {
        return questionRepository.findById(questionId)
                .map(question -> question.getAnswers().stream()
                        .filter(answer -> answer.getId().equals(answerId))
                        .findFirst()
                        .map(tech.edwyn.gmw.infra.driven.store.Answer::getCorrect)
                        .orElse(false))
                .orElse(false);
    }
}
