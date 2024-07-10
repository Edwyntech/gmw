package tech.edwyn.gmw.infra.driven.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCorrectAnswerId implements Serializable {
    private Long userId;
    private Long questionId;
}
