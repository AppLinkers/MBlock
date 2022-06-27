package com.example.MBlock.dto.News;

import lombok.Data;

@Data
public class SetMainNewsReq {

    private Long oldNewsId;

    private Long newNewsId;
}
