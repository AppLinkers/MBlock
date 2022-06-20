package com.example.MBlock.service;

import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.repository.AnnounceRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnounceService {

    private final AnnounceRepository announceRepository;

    private final UserRepository userRepository;

    private final S3Uploader s3Uploader;

    // Create
    public void write(WriteAnnounceReq request) {
        String imgUrl = null;


    }
}
