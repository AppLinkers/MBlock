package com.example.MBlock.dto.announced;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AnnounceFindRes {

    private Long id;
    private String title;
    private String context;
    private String user_name;
    private String dateTime;

}
