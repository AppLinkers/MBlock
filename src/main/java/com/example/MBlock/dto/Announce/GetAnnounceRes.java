package com.example.MBlock.dto.Announce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAnnounceRes {

    private Long id;

    private String writer_name;

    private String title;

    private String context;

    private String imgUrl;

    private Integer viewCount;

    private String dateTime;
}
