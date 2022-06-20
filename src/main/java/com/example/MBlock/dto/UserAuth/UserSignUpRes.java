package com.example.MBlock.dto.UserAuth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpRes {

    private Long id;

    private String loginId;

    private String name;
}
