package tech.edwyn.gmw.infra.driven.store.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "questions")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String text;
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "question")
    @ToString.Exclude
    private Set<AnswerEntity> answers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        QuestionEntity questionEntity = (QuestionEntity) o;
        return id != null && Objects.equals(id, questionEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
