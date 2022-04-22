package com.example.MBlock.dto.userAuth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSignUpRes {

    private Long id;

    private String user_id;
}
