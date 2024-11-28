package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.infra.driven.store.entity.QuizEntity;
import tech.edwyn.gmw.infra.driven.store.mapper.QuizMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuizRepository;
import tech.edwyn.gmw.infra.driven.store.repository.UserRepository;

import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    @Override
    public Quiz save(Quiz quiz) {
        var quizEntity = quizRepository.save(QuizMapper.toEntity(quiz));
        return QuizMapper.toDomain(quizEntity);
    }

    @Override
    public List<Quiz> getAll(String email) {
        var user = userRepository.findByEmail(email).get();

        return quizRepository.findAll().stream()
                .sorted(Comparator.comparingLong(QuizEntity::getId))
                .map(quizEntity -> QuizMapper.toDomain(quizEntity, user))
                .toList();
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
