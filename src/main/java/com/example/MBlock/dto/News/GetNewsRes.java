package com.example.MBlock.dto.News;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetNewsRes {

    private Long id;

    private String profile_img;

    private String writer_name;

    private String writer_position;

    private String title;

    private String context;

    private String imgUrl;

    private Integer viewCount;

    private String dateTime;

    private boolean isMain;
}
