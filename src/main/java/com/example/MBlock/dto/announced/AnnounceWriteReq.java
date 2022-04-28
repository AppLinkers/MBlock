package com.example.MBlock.dto.announced;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AnnounceWriteReq {

    private String title;

    private String content;

    private String writer;

    private MultipartFile file;

}
