package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.QuestionWithAnswers;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;
import tech.edwyn.gmw.infra.driven.store.mapper.QuizMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuizRepository quizRepository;

    @Override
    public List<Quiz> getAll() {
        return quizRepository.findAll().stream()
                .map(quiz -> new Quiz(quiz.getId(), quiz.getQuestions().stream()
                        .map(questionEntity -> new QuestionWithAnswers(
                                QuizMapper.toDomain(questionEntity),
                                questionEntity.getAnswers().stream()
                                        .sorted(Comparator.comparing(AnswerEntity::getId))
                                        .map(QuizMapper::toDomain)
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public Quiz getDefaultQuiz() {
        return getQuiz(1L);
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .map(quiz -> new Quiz(quiz.getId(), quiz.getQuestions().stream()
                        .map(questionEntity -> new QuestionWithAnswers(
                                QuizMapper.toDomain(questionEntity),
                                questionEntity.getAnswers().stream()
                                        .sorted(Comparator.comparing(AnswerEntity::getId))
                                        .map(QuizMapper::toDomain)
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList())))
                .orElseThrow();
    }
}
