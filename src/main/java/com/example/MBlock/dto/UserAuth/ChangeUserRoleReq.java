package com.example.MBlock.dto.UserAuth;

import lombok.Data;

@Data
public class ChangeUserRoleReq {

    private String userLoginId;

    private String role;

}
