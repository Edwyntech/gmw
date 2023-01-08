
package tech.edwyn.gmw.domain.store;

import tech.edwyn.gmw.domain.model.User;

// driven
public interface UserStoreSpi {
    User add(String name);

    Boolean hasAlreadyName(String name);
}
