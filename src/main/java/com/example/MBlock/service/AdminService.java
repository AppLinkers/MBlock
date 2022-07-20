package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.CurrencyInfo;
import com.example.MBlock.domain.Partner;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.TradingSite;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.dto.CurrencyInfo.AddCurrencyInfo;
import com.example.MBlock.dto.CurrencyInfo.GetCurrencyInfoRes;
import com.example.MBlock.dto.Partner.AddPartnerReq;
import com.example.MBlock.dto.Partner.GetPartnerRes;
import com.example.MBlock.repository.CurrencyInfoRepository;
import com.example.MBlock.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final PartnerRepository partnerRepository;

    private final CurrencyInfoRepository currencyInfoRepository;

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
                            .id(p.getId())
                            .name(p.getName())
                            .imgUrl(p.getImgUrl()).build());
                }
        );

        return result;
    }

    @Modifying
    public void deletePartner(Long partnerId) {
        Partner partner = partnerRepository.findById(partnerId).get();

        partnerRepository.delete(partner);

    }

    public List<GetCurrencyInfoRes> getCurrencyInfoResAllOfTradingSite(String tradingSite) {
        List<CurrencyInfo> currencyInfoList = currencyInfoRepository.getAllByTradingSiteIs(TradingSite.valueOf(tradingSite));

        List<GetCurrencyInfoRes> result = new ArrayList<>();

        currencyInfoList.forEach(
                c -> {
                    result.add(GetCurrencyInfoRes.builder()
                            .code(c.getCode())
                            .name(c.getName())
                            .imgUrl(c.getImgUrl())
                            .tradingSite(c.getTradingSite().toString())
                            .build());
                }
        );

        return result;
    }

    public void addCoin(AddCurrencyInfo request) throws IOException {
        String imgUrl = null;

        if (request.getImgFile() != null) {
            imgUrl = s3Uploader.upload(request.getImgFile().get(), "coinLogo");
        }

        CurrencyInfo currencyInfo = CurrencyInfo.builder()
                .code(request.getCode())
                .name(request.getName())
                .imgUrl(imgUrl)
                .tradingSite(request.getTradingSite())
                .build();

        currencyInfoRepository.save(currencyInfo);
    }
}
