package tech.edwyn.gmw.domain;

import tech.edwyn.gmw.domain.model.User;

//driving
public interface UserHandlerApi {
    User add(String name);

    Boolean hasAlreadyName(String name);
}
