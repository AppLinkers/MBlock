package com.example.MBlock.controller;

import com.example.MBlock.dto.analyzed.AnalyzedFindRes;
import com.example.MBlock.dto.analyzed.AnalyzedWriteReq;
import com.example.MBlock.dto.announced.AnnounceFindRes;
import com.example.MBlock.dto.announced.AnnounceWriteReq;
import com.example.MBlock.service.AnalyzedService;
import com.example.MBlock.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AnalyzedService analyzedService;
    private final AnnounceService announceService;

    @GetMapping("/memberManage")
    public String getMemberManagePage() {
        return "memberManage";
    }

    @GetMapping("/analyzeManage")
    public String getAnalyzeManagePage(Model model, @RequestParam(defaultValue = "0") int page) {

        Page<AnalyzedFindRes> analyzedFindResList = analyzedService.findAll(page);

        model.addAttribute("analyses", analyzedFindResList);
        return "analyzeManage";
    }

    @GetMapping("/announceManager")
    public String getAnnounceManager(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<AnnounceFindRes> announceFindResList = announceService.findAll(page);
        model.addAttribute("announce", announceFindResList);
        return "announceManager";
    }

    @GetMapping("/InvestManage")
    public String getInvestManager(){return "InvestManage";}

    @GetMapping("/qnaChat")
    public String getQnaChatPage() {
        return "qnaChat";
    }

    @GetMapping("/addAnalyzedPage")
    public String getAddAnnouncePage(Model model, @RequestParam("type")String type) {
        model.addAttribute("boardType", type);
        return "addBoards";
    }

    @PostMapping("/addAnalyzed")
    public String writeAnalyzeManage(AnalyzedWriteReq analyzedWriteReq, Authentication authentication) {
        String name = authentication.getName();

        analyzedWriteReq.setWriter(name);

        analyzedService.write(analyzedWriteReq);
        return "redirect:/admin/analyzeManage";
    }

    @PostMapping("/addAnnounce")
    public String writeAnnounce(AnnounceWriteReq announceWriteReq, Authentication authentication){
        String name = authentication.getName();

        announceWriteReq.setWriter(name);

        announceService.write(announceWriteReq);
        return "redirect:/admin/announceManager";
    }

    @GetMapping("/addInvest")
    public String getAddInvestPage(){ return "addInvest";}
}
