package tech.edwyn.gmw.infra.driven.store.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "quizzes")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "quiz")
    @ToString.Exclude
    private Set<QuestionEntity> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        QuizEntity questionEntity = (QuizEntity) o;
        return id != null && Objects.equals(id, questionEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
