
package tech.edwyn.gmw.domain.store;

// driven
public interface AnswerStoreSpi {
    boolean findIsCorrectByQuestionId(Long questionId, Long answerId);
}
