package tech.edwyn.gmw.infra.driven.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tech.edwyn.gmw.domain.store.AnswerStoreSpi;

@Component
@RequiredArgsConstructor
public class AnswerStoreAdapter implements AnswerStoreSpi {
    private final AnswerRepository answerRepository;

    @Override
    public Boolean findIsCorrectByQuestionId(Long questionId, Long answerId) {
        return answerRepository.findByQuestionId(questionId).stream()
                .filter(answer -> answer.getId().equals(answerId))
                .map(AnswerEntity::getCorrect)
                .findFirst()
                .orElse(false);
    }
}
