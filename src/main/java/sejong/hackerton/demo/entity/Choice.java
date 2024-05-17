package sejong.hackerton.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Choice {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private boolean isAnswer;
    private String context;
}
