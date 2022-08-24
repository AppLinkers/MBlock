package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.Youtube;
import com.example.MBlock.dto.Youtube.WriteYoutubeReq;
import com.example.MBlock.repository.YoutubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class YoutubeService {

    private final YoutubeRepository youtubeRepository;

    private final S3Uploader s3Uploader;

    public void save(WriteYoutubeReq writeYoutubeReq) throws IOException {
        String imgUrl = null;

        if (writeYoutubeReq.getImgFile() != null) {
            imgUrl = s3Uploader.upload(writeYoutubeReq.getImgFile().get(), "announce");
        }

        Youtube youtube = Youtube.builder()
                .title(writeYoutubeReq.getTitle())
                .url(writeYoutubeReq.getUrl())
                .imgUrl(imgUrl)
                .build();

        youtubeRepository.save(youtube);
    }
}
