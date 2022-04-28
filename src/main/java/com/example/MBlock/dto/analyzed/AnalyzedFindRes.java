package com.example.MBlock.dto.analyzed;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AnalyzedFindRes {

    private Long id;
    private String title;
    private String context;
    private String user_name;
    private String dateTime;
}
