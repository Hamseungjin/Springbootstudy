package com.example.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSignUpReqDto {

    private String email;
    private String password;
    private Integer age;

}
