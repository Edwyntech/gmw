package tech.edwyn.gmw.infra.driven.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString(exclude = {"answers", "quiz", "userCorrectAnswers"})
@Builder
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String text;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<AnswerEntity> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private QuizEntity quiz;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<UserCorrectAnswerEntity> userCorrectAnswers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionEntity)) return false;
        QuestionEntity that = (QuestionEntity) o;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
