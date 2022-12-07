package tech.edwyn.gmw.infra.driven.store;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questions")
@Data
@EqualsAndHashCode(exclude = "answers")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String type;
    @Column
    private String text;
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;
}
