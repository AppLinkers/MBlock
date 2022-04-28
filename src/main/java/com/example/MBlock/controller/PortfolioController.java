package com.example.MBlock.controller;

import com.example.MBlock.dto.analyzed.AnalyzedFindRes;
import com.example.MBlock.service.AnalyzedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("portfolio/")
@RequiredArgsConstructor
public class PortfolioController {

    private final AnalyzedService analyzedService;

    @GetMapping("analyzedBoard")
    public String getAnalyzedBoard(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<AnalyzedFindRes> analyzedFindResList = analyzedService.findAll(page);

        model.addAttribute("analyses", analyzedFindResList);

        return "AnalyzedBoard";
    }
    

    @GetMapping("investedBoard")
    public String getInvestedBoard() {
        return "InvestedBoard";
    }
}
