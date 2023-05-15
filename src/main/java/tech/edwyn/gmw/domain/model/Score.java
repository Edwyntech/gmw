package tech.edwyn.gmw.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Score {
    private final String text;
    private final Integer score;
    private final Integer maxScore;

    public Score(String text, Integer score, Integer maxScore) {
        this.text = text;
        this.score = score;
        this.maxScore = maxScore;
    }
}
