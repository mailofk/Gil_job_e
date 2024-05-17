package sejong.hackerton.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private Integer exp;
    private String password;
    @CreatedDate
    private LocalDateTime createAt;
    private Integer level;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<TodoList> todoLists= new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String email,String password,Authority authority ){
        this.email =email;
        this.password =password;
        this.authority=authority;
        this.level=1;
        this.exp=0;
    }

    public Member(){
        this.level=1;
        this.exp=0;
    }
}
