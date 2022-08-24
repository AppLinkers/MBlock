package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.Youtube;
import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Youtube.GetYoutubeRes;
import com.example.MBlock.dto.Youtube.UpdateYoutubeReq;
import com.example.MBlock.dto.Youtube.WriteYoutubeReq;
import com.example.MBlock.repository.YoutubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class YoutubeService {

    private final YoutubeRepository youtubeRepository;

    private final S3Uploader s3Uploader;


    /**
     * Read All youtuber
     */
    public Page<GetYoutubeRes> getAllYoutuber(Pageable pageable) {
        Page<Youtube> findYoutubeList = youtubeRepository.findAll(pageable);

        return findYoutubeList.map(youtube ->
                new GetYoutubeRes(
                        youtube.getId(),
                        youtube.getTitle(),
                        youtube.getUrl(),
                        youtube.getImgUrl(),
                        youtube.isOnAir()
                )
        );
    }


    public GetYoutubeRes getYoutubeById(Long id) {
        Youtube findYoutube = youtubeRepository.getById(id);

        return GetYoutubeRes.builder()
                .id(findYoutube.getId())
                .onAir(findYoutube.isOnAir())
                .title(findYoutube.getTitle())
                .build();
    }


    /**
     * update All youtuber
     */

    public void updateYoutube(UpdateYoutubeReq request){
        Youtube youtuber = youtubeRepository.getById(request.getId());
        youtuber.setOnAir(request.isOnAir());
        youtubeRepository.save(youtuber);
    }


    public void save(WriteYoutubeReq writeYoutubeReq) throws IOException {
        String imgUrl = null;

        if (writeYoutubeReq.getImgFile() != null) {
            imgUrl = s3Uploader.upload(writeYoutubeReq.getImgFile().get(), "announce");
        }

        Youtube youtube = Youtube.builder()
                .title(writeYoutubeReq.getTitle())
                .url(writeYoutubeReq.getUrl())
                .imgUrl(imgUrl)
                .onAir(false)
                .build();
        youtubeRepository.save(youtube);
    }
}
