package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.Consulting;
import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.repository.ConsultingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultingService {

    private final ConsultingRepository consultingRepository;

    public void writeConsulting(WriteConsultingReq request) {
        Consulting consulting = Consulting.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .trader(request.getTrader())
                .context(request.getContext())
                .privacy(request.isPrivacy())
                .build();

        consultingRepository.save(consulting);

    }

    public List<GetConsultingRes> getAllConsulting() {
        List<GetConsultingRes> result = new ArrayList<>();

        List<Consulting> consultingList = consultingRepository.findAll();

        consultingList.forEach(
                c -> {
                    result.add(GetConsultingRes.builder()
                            .id(c.getId())
                            .name(c.getName())
                            .phone(c.getPhone())
                            .email(c.getEmail())
                            .context(c.getContext())
                            .replied(c.isReplied())
                            .trader(c.getTrader())
                            .datetime(c.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd"))).build());
                }
        );

        return result;
    }

    public void consultReply(Long id){
        Consulting consulting = consultingRepository.findById(id).get();
        consulting.setReplied(true);
        consultingRepository.save(consulting);
    }


    public GetConsultingRes getConsulting(Long id) {
        Consulting consulting = consultingRepository.findById(id).get();

        return GetConsultingRes.builder()
                .id(consulting.getId())
                .replied(consulting.isReplied())
                .name(consulting.getName())
                .context(consulting.getContext())
                .email(consulting.getEmail())
                .phone(consulting.getPhone())
                .trader(consulting.getTrader())
                .datetime(consulting.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }

    @Modifying
    public void deleteConsulting(Long consultingId) {
        Consulting consulting = consultingRepository.findById(consultingId).get();

        consultingRepository.delete(consulting);
    }
}
