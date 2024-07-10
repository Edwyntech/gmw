package tech.edwyn.gmw.infra.driven.store.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCorrectAnswerId implements Serializable {
    private Long userId;
    private Long questionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCorrectAnswerId)) return false;
        UserCorrectAnswerId that = (UserCorrectAnswerId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, questionId);
    }

    @Override
    public String toString() {
        return "UserCorrectAnswerId{" +
                "userId=" + userId +
                ", questionId=" + questionId +
                '}';
    }
}