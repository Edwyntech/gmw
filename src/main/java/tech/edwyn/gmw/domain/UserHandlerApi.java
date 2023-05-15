package tech.edwyn.gmw.domain;

import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.infra.driving.model.ScoreResponse;

//driving
public interface UserHandlerApi {
    User add(String firstName, String lastName, String email);

    Boolean hasAlreadyName(String name);

    ScoreResponse getScore(String name, Long quizzId);
}
