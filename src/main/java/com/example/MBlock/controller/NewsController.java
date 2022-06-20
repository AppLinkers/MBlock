package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class NewsController {



    @GetMapping("/news")
    public String getNews(){return "news";}
}
