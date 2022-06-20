package com.example.MBlock.dto.Announce;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class WriteAnnounceReq {

    private Long writer_id;

    private String title;

    private String context;

    private Optional<MultipartFile> imgFile;
}
