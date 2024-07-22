package tech.edwyn.gmw.infra.driven.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user_correct_answers")
@NoArgsConstructor
@AllArgsConstructor
public class UserCorrectAnswerEntity {
    @EmbeddedId
    private UserCorrectAnswerId id = new UserCorrectAnswerId();

    @ManyToOne
    @MapsId("userId")
    private UserEntity user;

    @ManyToOne
    @MapsId("questionId")
    private QuestionEntity question;

    @Column(name = "creation_date")
    private Date creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCorrectAnswerEntity)) return false;
        UserCorrectAnswerEntity that = (UserCorrectAnswerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserCorrectAnswerEntity{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }
}