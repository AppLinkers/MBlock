package com.example.MBlock.dto.UserAuth;

import com.example.MBlock.domain.type.Approved;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class UserUpdateReq {


    private String role;

    private String phone;

    private Optional<MultipartFile> profileImg;

    private Approved approved;
}
