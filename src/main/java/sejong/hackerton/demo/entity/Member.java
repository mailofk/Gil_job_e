package sejong.hackerton.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nickname;
    private Integer exp;
    private LocalDateTime createAt;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<TodoList> todoLists= new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Authority authority;





}
