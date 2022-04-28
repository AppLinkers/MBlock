package com.example.MBlock.service;

import com.example.MBlock.domain.Analyzed;
import com.example.MBlock.domain.Announce;
import com.example.MBlock.dto.analyzed.AnalyzedFindRes;
import com.example.MBlock.dto.analyzed.AnalyzedWriteReq;
import com.example.MBlock.dto.announced.AnnounceFindRes;
import com.example.MBlock.dto.announced.AnnounceWriteReq;
import com.example.MBlock.repository.AnalyzedRepository;
import com.example.MBlock.repository.AnnouncedRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AnnounceService {

    private final UserRepository userRepository;
    private final AnnouncedRepository announcedRepository;

    public Page<AnnounceFindRes> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Announce> findAnnounceList = announcedRepository.findAll(pageRequest);

        Page<AnnounceFindRes> result = findAnnounceList.map(announce ->
                new AnnounceFindRes(announce.getId(), announce.getTitle(), announce.getContext() ,announce.getUser_name(), announce.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        );

        return result;
    }

    public void write(AnnounceWriteReq request) {

        String name = userRepository.findUserNameByUser_id(request.getWriter());
        request.setWriter(name);

        Announce announce = Announce.builder()
                .title(request.getTitle())
                .user_name(request.getWriter())
                .context(request.getContent())
                .build();

        if (request.getFile() != null) {
            announce.setFile_url("file exist");
        } else {
            announce.setFile_url("file null");
        }

        announcedRepository.save(announce);
    }
}
