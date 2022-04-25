package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("portfolio/")
@RequiredArgsConstructor
public class PortfolioController {

    @GetMapping("analyzedBoard")
    public String getAnalyzedBoard() {
        return "AnalyzedBoard";
    }
    

    @GetMapping("investedBoard")
    public String getInvestedBoard() {
        return "InvestedBoard";
    }
}
