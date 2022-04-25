package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("business/")
@RequiredArgsConstructor
public class BusinessController {

    @GetMapping("crew")
    public String getCrewPage() {
        return "Crew";
    }

    @GetMapping("business")
    public String getBusinessPage(){return "business";}
}
