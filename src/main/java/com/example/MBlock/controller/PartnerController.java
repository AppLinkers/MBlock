package com.example.MBlock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class PartnerController {

    @GetMapping("/partners/add")
    public String addPartners(Model model) {
        return "admin_partner_add";
    }


}
