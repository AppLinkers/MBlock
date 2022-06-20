package com.example.MBlock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/invest")
    public String getInvest(){return "invest";}

    @GetMapping("/contact")
    public String getContact(){return "contact";}

    @GetMapping("/consulting")
    public String getConsulting(){return "consulting";}

    @GetMapping("/business")
    public String getBusiness(){return "business";}
}
