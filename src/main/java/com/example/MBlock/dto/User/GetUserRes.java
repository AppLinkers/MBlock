package com.example.MBlock.dto.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserRes {

    private String name;

    private String role;

    private String imgUrl;
}
