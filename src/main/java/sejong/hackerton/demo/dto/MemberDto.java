package sejong.hackerton.demo.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private String nickname;
    private String email;
    private Integer exp;
    private int level;

}
