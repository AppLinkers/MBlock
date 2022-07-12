package com.example.MBlock.controller;

import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.service.ConsultingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ConsultingController {

    private final ConsultingService consultingService;

    /**
     * Write Consulting Page
     */
    @GetMapping("/consulting/form")
    public String writeConsultingPage(WriteConsultingReq writeConsultingReq){return "consulting";}

    /**
     * Write Consulting Service
     */
    @PostMapping("/consulting")
    public String writeConsulting(WriteConsultingReq writeConsultingReq) {
        consultingService.writeConsulting(writeConsultingReq);
        return "redirect:/consulting/form";
    }

    /**
     * Read All Consulting Page for Admin
     */
    @GetMapping("/admin/consulting")
    public String manageConsult(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable ){
        List<GetConsultingRes> consultList = consultingService.getAllConsulting(pageable);
        model.addAttribute("consultList", consultList);
        return "admin_consult";
    }

    /**
     * Read One Consulting Page for Admin
     */
    @GetMapping("/admin/consulting/{id}")
    public String consultDetail(Model model, @PathVariable("id") Long id){
        GetConsultingRes consult = consultingService.getConsulting(id);
        model.addAttribute("consult", consult);
        return "admin_consult_detail";
    }

    /**
     * Check Reply Consulting Service for Admin
     */
    @PostMapping("/admin/consulting/{id}")
    public String consultReply(@PathVariable(value="id") Long id){
        consultingService.consultReply(id);
        return "redirect:/admin/consulting";
    }

}
