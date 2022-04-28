package com.example.MBlock.dto.analyzed;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AnalyzedWriteReq {

    private String title;

    private String content;

    private String writer;

    private MultipartFile file;
}
