package com.example.MBlock.dto.Youtube;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class WriteYoutubeReq {

    private String title;

    private String info;

    private String hotClip;

    private Integer subscribers;

    private String url;

    private boolean onAir;

    private Optional<MultipartFile> imgFile;

}
