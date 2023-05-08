package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.infra.driven.store.mapper.QuizMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuizRepository quizRepository;

    @Override
    public Quiz save(Quiz quiz) {
        var quizEntity = quizRepository.save(QuizMapper.toEntity(quiz));
        return QuizMapper.toDomain(quizEntity);
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepository.findAll().stream()
                .map(QuizMapper::toDomain)
                .toList();
    }

    @Override
    public Quiz getDefaultQuiz() {
        return getQuiz(1L);
    }

    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id)
                .map(QuizMapper::toDomain)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        quizRepository.deleteById(id);
    }
}
