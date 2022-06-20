package com.example.MBlock.dto.UserAuth;
import lombok.Data;

@Data
public class UserSignUpReq {

    private String loginId;

    private String loginPw;

    private String role;

    private String phone;

    // 더 추가 필요
}
