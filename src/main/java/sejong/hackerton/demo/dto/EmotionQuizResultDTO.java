package sejong.hackerton.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmotionQuizResultDTO {
    private Integer exp;
    private Integer level;
    private boolean correct;
    private String explanation;
}
