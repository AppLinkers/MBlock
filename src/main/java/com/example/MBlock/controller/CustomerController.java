package com.example.MBlock.controller;

import com.example.MBlock.dto.announced.AnnounceFindRes;
import com.example.MBlock.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("customer/")
@RequiredArgsConstructor
public class CustomerController {


    private final AnnounceService announceService;

    @GetMapping("qna")
    public String getQnaPage(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<AnnounceFindRes> announceFindResList = announceService.findAll(page);
        model.addAttribute("announce", announceFindResList);
        return "customer";
    }
}
