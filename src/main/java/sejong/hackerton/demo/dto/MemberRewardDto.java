package sejong.hackerton.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRewardDto {

    private String nickname;
    private Integer exp;
    private int level;
    private int correctNumber;


}