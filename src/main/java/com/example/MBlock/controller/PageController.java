package com.example.MBlock.controller;

import com.example.MBlock.domain.Message;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.dto.Message.MessageReq;
import com.example.MBlock.service.AdminService;
import com.example.MBlock.service.ConsultingService;
import com.example.MBlock.service.MessageService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final AdminService adminService;

    private final UserService userService;
    private final MessageService messageService;

    private final ConsultingService consultingService;

    @GetMapping("/invest")
    public String getInvest(){return "invest";}

    @GetMapping("/contact")
    public String getContact(){return "contact";}

    @GetMapping("/consulting")
    public String getConsulting(WriteConsultingReq writeConsultingReq){return "consulting";}

    @PostMapping("/consulting")
    public String writeConsulting(WriteConsultingReq writeConsultingReq, MessageReq message) {
        consultingService.writeConsulting(writeConsultingReq);
        messageService.send(message);
        return "redirect:/consulting";
    }

    @GetMapping("/business")
    public String getBusiness(Model model){
        model.addAttribute("userList", userService.getUserProfileAll());
        model.addAttribute("partnerList", adminService.getPartnerAll());

        return "business";
    }



}
