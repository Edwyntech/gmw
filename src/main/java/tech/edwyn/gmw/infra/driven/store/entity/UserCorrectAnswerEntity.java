package tech.edwyn.gmw.infra.driven.store.entity;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Date;

@EqualsAndHashCode
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

}
