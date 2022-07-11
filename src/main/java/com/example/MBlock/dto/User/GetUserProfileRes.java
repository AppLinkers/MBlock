package com.example.MBlock.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserProfileRes {

    private String name;

    private String position;

    private String imgUrl;
}
