package sejong.hackerton.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private Integer exp;

    @CreatedDate
    private LocalDateTime createAt;
    private Integer level;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Authority authority;





}
