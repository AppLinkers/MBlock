package com.example.MBlock.service;

import com.example.MBlock.domain.Partner;
import com.example.MBlock.dto.Partner.AddPartnerReq;
import com.example.MBlock.dto.Partner.GetPartnerRes;
import com.example.MBlock.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final PartnerRepository partnerRepository;

    private final S3Uploader s3Uploader;

    public void addPartner(AddPartnerReq request) throws IOException {
        String imgUrl = null;

        if (request.getProfileImg() != null) {
            imgUrl = s3Uploader.upload(request.getProfileImg(), "partner");
        }

        Partner partner = Partner.builder()
                .name(request.getName())
                .imgUrl(imgUrl)
                .build();

        partnerRepository.save(partner);

    }

    public List<GetPartnerRes> getPartnerAll() {
        List<GetPartnerRes> result = new ArrayList<>();

        List<Partner> partnerList = partnerRepository.findAll();

        partnerList.forEach(
                p -> {
                    result.add(GetPartnerRes.builder()
                            .name(p.getName())
                            .imgUrl(p.getImgUrl()).build());
                }
        );

        return result;
    }
}
