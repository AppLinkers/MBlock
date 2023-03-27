package com.example.MBlock.service;

import com.example.MBlock.domain.Youtube;
import com.example.MBlock.dto.Youtube.GetYoutubeRes;
import com.example.MBlock.dto.Youtube.UpdateYoutubeReq;
import com.example.MBlock.dto.Youtube.WriteYoutubeReq;
import com.example.MBlock.repository.YoutubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                GetYoutubeRes.builder()
                        .id(youtube.getId())
                        .title(youtube.getTitle())
                        .info(youtube.getInfo())
                        .hotClip(youtube.getHotClip())
                        .url(youtube.getUrl())
                        .imgFile(youtube.getImgUrl())
                        .subscribers(youtube.getSubscribers())
                        .onAir(youtube.isOnAir())
                        .apiKey(youtube.getApiKey())
                        .secretKey(youtube.getSecretKey() != null ? youtube.getSecretKey().get() : "")
                        .build()
        );
    }

    public List<String> getAllYoutuberName() {
        List<String> response = new ArrayList<>();

        youtubeRepository.findAll().forEach(
                youtube -> {
                    response.add(youtube.getTitle());
                }
        );

        return response;
    }


    public GetYoutubeRes getYoutubeById(Long id) {
        Youtube findYoutube = youtubeRepository.getById(id);

        return GetYoutubeRes.builder()
                .id(findYoutube.getId())
                .hotClip(findYoutube.getHotClip())
                .info(findYoutube.getInfo())
                .url(findYoutube.getUrl())
                .onAir(findYoutube.isOnAir())
                .imgFile(findYoutube.getImgUrl())
                .title(findYoutube.getTitle())
                .apiKey(findYoutube.getApiKey())
                .build();
    }


    /**
     * update youtuber
     */
    public void updateYoutube(UpdateYoutubeReq request){
        Youtube youtuber = youtubeRepository.getById(request.getId());
        youtuber.setTitle(request.getTitle());
        youtuber.setInfo(request.getInfo());
        youtuber.setHotClip(request.getHotClip());
        youtuber.setSubscribers(request.getSubscribers());
        youtuber.setApiKey(request.getAPI_KEY());
        youtuber.setSecretKey(java.util.Optional.ofNullable(request.getSECRET_KEY()));
        youtuber.setOnAir(request.isOnAir());
        youtubeRepository.save(youtuber);
    }


    public void save(WriteYoutubeReq writeYoutubeReq) throws IOException {
        String imgUrl = null;

        if (writeYoutubeReq.getImgFile() != null) {
            imgUrl = s3Uploader.upload(writeYoutubeReq.getImgFile().get(), "youtube");
        }

        Youtube youtube = Youtube.builder()
                .title(writeYoutubeReq.getTitle())
                .info(writeYoutubeReq.getInfo())
                .url(writeYoutubeReq.getUrl())
                .hotClip(writeYoutubeReq.getHotClip())
                .subscribers(writeYoutubeReq.getSubscribers())
                .imgUrl(imgUrl)
                .onAir(false)
                .build();
        youtubeRepository.save(youtube);
    }
}
