package com.example.MBlock.dto.Youtube;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetYoutubeRes {

    private Long id;
    private String title;

    private String url;

    private String imgFile;

    private boolean onAir;
}
