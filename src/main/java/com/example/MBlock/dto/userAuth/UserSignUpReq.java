package com.example.MBlock.dto.userAuth;

import lombok.Data;

@Data
public class UserSignUpReq {

    private String username;

    private String password;

    private String role;
}
