package com.example.MBlock.dto.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserInfoRes {

    private Long id;

    private String login_id;

    private String name;

    private String role;

    private String phone;

    private String approved;

    private String profile_img;

}
