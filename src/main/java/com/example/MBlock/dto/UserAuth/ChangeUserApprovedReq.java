package com.example.MBlock.dto.UserAuth;

import lombok.Data;

@Data
public class ChangeUserApprovedReq {

    private String userLoginId;

    private String approved;

}
