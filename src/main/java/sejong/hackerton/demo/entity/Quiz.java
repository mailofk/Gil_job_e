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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public static Integer sequenceNum = 0;

    private String choice1;
    private String choice2;
    private String choice3;

    private String question;

    private int answer;

    private String explanation;

}
