
package tech.edwyn.gmw.domain.store;

import tech.edwyn.gmw.domain.model.User;

// driven
public interface UserStoreSpi {
    User add(String firstName, String lastName, String email);

    Boolean hasAlreadyEmail(String email);

    User addCorrectQuestion(String name, Long questionId);

    Integer getScore(String name);
}
