package com.example.MBlock.dto.UserAuth;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserSignUpReq {

    private String name;

    private String loginId;

    private String loginPw;

    private String role;

    private String phone;

    private MultipartFile profileImg;
}
