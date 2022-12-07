package tech.edwyn.gmw.infra.driven.store;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
@EqualsAndHashCode(exclude = "question")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String type;
    @Column
    private Boolean correct;
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
