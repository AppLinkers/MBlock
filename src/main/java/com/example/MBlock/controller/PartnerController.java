package com.example.MBlock.controller;

import com.example.MBlock.dto.Partner.AddPartnerReq;
import com.example.MBlock.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class PartnerController {

    private final AdminService adminService;

    /**
     * Read All Partner Page for Admin
     */
    @GetMapping("/admin/partner")
    public String managePartner(Model model) {
        model.addAttribute("partnerList", adminService.getPartnerAll());
        return "admin_partner";
    }

    /**
     * Add Partner Page
     */
    @GetMapping("/admin/partner/form")
    public String addPartnerPage(AddPartnerReq addPartnerReq) {
        return "admin_partner_add";
    }

    /**
     * Add Partner Service
     */
    @PostMapping("/admin/partner")
    public String addPartner(AddPartnerReq addPartnerReq) throws IOException {
        adminService.addPartner(addPartnerReq);
        return "redirect:/admin/partner";
    }

    /**
     * /delete 제거
     * Delete Partner Service
     */
    @GetMapping("/admin/partner/{id}")
    public String deletePartner(@PathVariable(value = "id") long id){
        adminService.deletePartner(id);
        return "redirect:/admin/partner";
    }


}
