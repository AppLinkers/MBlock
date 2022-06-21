package com.example.MBlock.controller;

import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;


    @GetMapping("/invest")
    public String getInvest(){return "invest";}

    @GetMapping("/contact")
    public String getContact(){return "contact";}

    @GetMapping("/consulting")
    public String getConsulting(){return "consulting";}

    @GetMapping("/business")
    public String getBusiness(Model model){

        System.out.println(userService.getUserAll());

        model.addAttribute("userList", userService.getUserAll());

        return "business";
    }

}
