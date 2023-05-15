package tech.edwyn.gmw.domain;

import lombok.RequiredArgsConstructor;
import tech.edwyn.gmw.domain.model.Score;
import tech.edwyn.gmw.domain.model.User;
import tech.edwyn.gmw.domain.store.UserStoreSpi;
import tech.edwyn.gmw.infra.driving.model.ScoreResponse;

@RequiredArgsConstructor
public class UserService implements UserHandlerApi {
    private final UserStoreSpi userStoreSpi;

    @Override
    public User add(String firstName, String lastName, String email) {
        return userStoreSpi.add(firstName, lastName, email);
    }

    @Override
    public Boolean hasAlreadyName(String email) {
        return userStoreSpi.hasAlreadyEmail(email);
    }

    @Override
    public ScoreResponse getScore(String email, Long quizId) {
        Score score = userStoreSpi.getScore(email, quizId);
        return new ScoreResponse(email, score.getScore(), score.getText());
    }
}
