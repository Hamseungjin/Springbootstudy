package com.example.board.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private Integer age;


    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<Board>();

    public Member(String email, String password, Integer age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}
