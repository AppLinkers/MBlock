package com.example.MBlock.service;

import com.example.MBlock.domain.Consulting;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.repository.ConsultingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
