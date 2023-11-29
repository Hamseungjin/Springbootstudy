package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembersRequestUpdate {
    private String email;
    private String oldPassword;
    private String newPassword;
}

