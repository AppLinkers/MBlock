package com.example.MBlock.controller;

import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AnnounceController {

    private final AnnounceService announceService;

    @GetMapping("/announce")
    public String getAnnounce(@PageableDefault(size=10, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<GetAnnounceRes> announceList = announceService.getAnnounceAll(pageable);

        return "announce";
    }

}
