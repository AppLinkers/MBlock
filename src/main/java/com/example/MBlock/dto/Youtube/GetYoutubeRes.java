package com.example.MBlock.dto.Youtube;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Getter
public class GetYoutubeRes {

    private Long id;

    private String title;

    private String info;

    private String hotClip;

    private String url;

    private String imgFile;

    private Integer subscribers;

    private boolean onAir;

    private String apiKey;

    private String secretKey;

    @Builder
    public GetYoutubeRes(Long id, String title, String info, String hotClip, String url, String imgFile, Integer subscribers, boolean onAir, String apiKey, String secretKey) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.hotClip = hotClip;
        this.url = url;
        this.imgFile = imgFile;
        this.subscribers = subscribers;
        this.onAir = onAir;
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }
}
