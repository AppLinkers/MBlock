package com.example.MBlock.dto.Youtube;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class UpdateYoutubeReq {

    private Long id;

    private String title;

    private String url;

    private boolean onAir;

    private Optional<MultipartFile> imgFile;

}
