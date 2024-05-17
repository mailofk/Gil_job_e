package sejong.hackerton.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonQuizDto {
    private String quizTitle;

    private String quizChoice1;
    private String quizChoice2;
    private String quizChoice3;

    private int answer;
    private String explanation;
}
