package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.model.Quiz;
import tech.edwyn.gmw.domain.store.QuizStoreSpi;
import tech.edwyn.gmw.infra.driven.store.entity.AnswerEntity;
import tech.edwyn.gmw.infra.driven.store.entity.QuestionEntity;
import tech.edwyn.gmw.infra.driven.store.mapper.QuizMapper;
import tech.edwyn.gmw.infra.driven.store.repository.QuestionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizStoreAdapter implements QuizStoreSpi {
    private final QuestionRepository questionRepository;

    @Override
    public List<Quiz> getAllQuizzes() {
        return questionRepository.findAll().stream()
                .sorted(Comparator.comparing(QuestionEntity::getId))
                .map(questionEntity -> new Quiz(
                        QuizMapper.toDomain(questionEntity),
                        questionEntity.getAnswers().stream()
                                .sorted(Comparator.comparing(AnswerEntity::getId))
                                .map(QuizMapper::toDomain)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
