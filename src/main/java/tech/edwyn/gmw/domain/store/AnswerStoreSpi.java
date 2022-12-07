
package tech.edwyn.gmw.domain.store;

// driven
public interface AnswerStoreSpi {
    Boolean findIsCorrectByQuestionId(Long questionId, Long answerId);
}
