package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/memberManage")
    public String getMemberManagePage() {
        return "memberManage";
    }

    @GetMapping("/analyzeManage")
    public String getAnalyzeManagePage() {
        return "analyzeManage";
    }

    @GetMapping("/announceManager")
    public String getAnnounceManager() {
        return "announceManager";
    }

    @GetMapping("/qnaChat")
    public String getQnaChatPage() {
        return "qnaChat";
    }

    @GetMapping("/addAnalyzed")
    public String getAddAnnouncePage() {
        return "addAnalyzed";
    }
}
