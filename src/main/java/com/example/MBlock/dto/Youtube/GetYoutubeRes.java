package com.example.MBlock.dto.Youtube;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Getter
public class GetYoutubeRes {

    private Long id;

    private String title;

    private String url;

    private String imgFile;

    private boolean onAir;

    private String apiKey;

    private String secretKey;

    @Builder
    public GetYoutubeRes(Long id, String title, String url, String imgFile, boolean onAir, String apiKey, String secretKey) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.imgFile = imgFile;
        this.onAir = onAir;
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }
}
