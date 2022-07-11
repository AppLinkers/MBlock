package com.example.MBlock.dto.UserAuth;

import com.example.MBlock.domain.type.Role;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class UserUpdateReq {


    private String position;

    private String phone;

    private Optional<MultipartFile> profile_img;

    private Role role;
}
