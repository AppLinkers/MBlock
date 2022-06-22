package com.example.MBlock.service;

import com.example.MBlock.domain.Consulting;
import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.repository.ConsultingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                            .trader(c.getTrader()).build());
                }
        );

        return result;
    }
}
