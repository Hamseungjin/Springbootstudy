package com.example.board.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne()
    @JoinColumn(name = "memberId")
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
