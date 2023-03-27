package com.example.MBlock.controller;

import com.example.MBlock.domain.Youtube;
import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.dto.ConsultingReply.GetConsultingReplyRes;
import com.example.MBlock.dto.ConsultingReply.WriteConsultingReplyReq;
import com.example.MBlock.dto.Youtube.GetYoutubeRes;
import com.example.MBlock.service.ConsultingService;
import com.example.MBlock.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ConsultingController {

    private final ConsultingService consultingService;
    private final YoutubeService youtubeService;

    /**
     * Write Consulting Page
     */
    @GetMapping("/consulting/form")
    public String writeConsultingPage(Model model,WriteConsultingReq writeConsultingReq ,@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        List<String> youtubeList = youtubeService.getAllYoutuberName();
        List<GetConsultingRes> consultList = consultingService.getAllConsulting(pageable);
        model.addAttribute("consult", consultList);
        model.addAttribute("youtube", youtubeList);
        return "consulting";}

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
    public String consultAdminDetail(Model model, @PathVariable("id") Long id ,WriteConsultingReplyReq writeConsultingReplyReq){
        GetConsultingRes consult = consultingService.getConsulting(id);
        model.addAttribute("consult", consult);
        Optional<GetConsultingReplyRes> consultingReplyRes = consultingService.getOneConsultingReplyByConsultingId(id);
        if (consultingReplyRes.isPresent()) {
            model.addAttribute("consultingReply", consultingReplyRes.get());
        }

        return "admin_consult_detail";
    }

    @GetMapping("/consulting/detail/{id}")
    public String consultDetail(Model model, @PathVariable("id") Long id ){
        GetConsultingRes consult = consultingService.getConsulting(id);
        model.addAttribute("consult", consult);
        Optional<GetConsultingReplyRes> consultingReplyRes = consultingService.getOneConsultingReplyByConsultingId(id);
        if (consultingReplyRes.isPresent()) {
            model.addAttribute("consultingReply", consultingReplyRes.get());
        }
        return "faq";
    }

    /**
     * Check Reply Consulting Service for Admin
     */
    @PostMapping("/admin/consulting")
    public String consultReply(WriteConsultingReplyReq writeConsultingReplyReq){
        String userLoginId = SecurityContextHolder.getContext().getAuthentication().getName();
        writeConsultingReplyReq.setUser_login_id(userLoginId);
        consultingService.consultReply(writeConsultingReplyReq);
        return "redirect:/admin/consulting";
    }

    @GetMapping("/qnaList")
    public String gotoQnaList(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable ){
        List<GetConsultingRes> consultList = consultingService.getAllConsulting(pageable);
        model.addAttribute("consultList", consultList);
        return "qna_list";
    }

    @GetMapping("/qna/{id}")
    public String qnaDetail(Model model, @PathVariable("id") Long id){
        GetConsultingRes consult = consultingService.getConsulting(id);
        model.addAttribute("consult", consult);
        Optional<GetConsultingReplyRes> consultingReplyRes = consultingService.getOneConsultingReplyByConsultingId(id);
        if (consultingReplyRes.isPresent()) {
            model.addAttribute("consultingReply", consultingReplyRes.get());
        }

        return "qnaDetail";
    }

}
