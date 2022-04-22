package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer/")
@RequiredArgsConstructor
public class CustomerController {

    @GetMapping("qna")
    public String getQnaPage() {
        return "customer";
    }
}
