package com.example.MBlock.controller;

import com.example.MBlock.dto.Partner.AddPartnerReq;
import com.example.MBlock.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class PartnerController {

    private final AdminService adminService;

    @GetMapping("/partners/add")
    public String addPartnersPage(AddPartnerReq addPartnerReq,Model model) {
        return "admin_partner_add";
    }

    @PostMapping("/partners/add")
    public String addPartners(AddPartnerReq addPartnerReq) throws IOException {
        adminService.addPartner(addPartnerReq);
        return "redirect:/admin/partners";
    }


}
