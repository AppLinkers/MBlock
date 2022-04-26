package com.example.MBlock.controller;

import com.example.MBlock.dto.analyzed.AnalyzedFindRes;
import com.example.MBlock.dto.analyzed.AnalyzedWriteReq;
import com.example.MBlock.service.AnalyzedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AnalyzedService analyzedService;

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
    public String getAnnounceManager() {
        return "announceManager";
    }

    @GetMapping("/InvestManage")
    public String getInvestManager(){return "InvestManage";}

    @GetMapping("/qnaChat")
    public String getQnaChatPage() {
        return "qnaChat";
    }

    @GetMapping("/addAnalyzed")
    public String getAddAnnouncePage() {
        return "addAnalyzed";
    }

    @PostMapping("/addAnalyzed")
    public String writeAnalyzeManage(AnalyzedWriteReq analyzedWriteReq, Authentication authentication) {
        String name = authentication.getName();

        analyzedWriteReq.setWriter(name);

        analyzedService.write(analyzedWriteReq);
        return "redirect:/admin/analyzeManage";
    }

    @GetMapping("/addInvest")
    public String getAddInvestPage(){ return "addInvest";}
}
