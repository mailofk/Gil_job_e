package sejong.hackerton.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Choice> choiceList = new ArrayList<>();

    private String question;


}
