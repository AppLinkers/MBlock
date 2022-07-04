package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.User;
import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.repository.AnnounceRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AnnounceService {

    private final AnnounceRepository announceRepository;

    private final UserRepository userRepository;

    private final S3Uploader s3Uploader;

    // Create
    public void write(WriteAnnounceReq request) throws IOException {
        String imgUrl = null;

        System.out.println(request);

        if (request.getImgFile() != null) {
            imgUrl = s3Uploader.upload(request.getImgFile().get(), "announce");
        }

        User user = userRepository.findByUser_id(request.getWriter_login_id()).get();

        Announce announce = Announce.builder()
                .user(user)
                .title(request.getTitle())
                .context(request.getContext())
                .imgUrl(imgUrl)
                .build();

        announceRepository.save(announce);
    }

    // Read All - Page
    public Page<GetAnnounceRes> getAnnounceAll(Pageable pageable) {
        Page<Announce> findAnnounceList = announceRepository.findAll(pageable);

        return findAnnounceList.map(announce ->
                new GetAnnounceRes(announce.getId(), announce.getUser().getName(),announce.getUser().getProfile_img() ,announce.getTitle(), announce.getContext(), announce.getImgUrl(), announce.getViewCount(), announce.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
        );
    }


    // Read One
    public GetAnnounceRes getAnnounce(Long id) {
        Announce announce = announceRepository.findById(id).get();

        announce.setViewCount(announce.getViewCount() + 1);
        announceRepository.save(announce);

        return GetAnnounceRes.builder()
                .writer_name(announce.getUser().getName())
                .writer_img(announce.getUser().getProfile_img())
                .title(announce.getTitle())
                .context(announce.getContext())
                .imgUrl(announce.getImgUrl())
                .viewCount(announce.getViewCount())
                .dateTime(announce.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }

    // Delete
    @Modifying
    public void deleteAnnounce(Long announceId, String writerId) {
        Announce announce = announceRepository.findById(announceId).get();

        if (announce.getUser().getLogin_id().equals(writerId)) {
            announceRepository.delete(announce);
        }
    }

    //update
    @Transactional
    public void updateAnnounce(WriteAnnounceReq request, Long announceId) throws IOException {
        Announce announce = announceRepository.findById(announceId).get();

        announce.setTitle(request.getTitle());
        announce.setContext(request.getContext());

        if (request.getImgFile() != null) {
            String imgUrl = s3Uploader.upload(request.getImgFile().get(), "announce");
            announce.setImgUrl(imgUrl);
        }


        announceRepository.save(announce);
    }


}
