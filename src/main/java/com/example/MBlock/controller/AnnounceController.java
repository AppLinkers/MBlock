package com.example.MBlock.controller;

import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AnnounceController {

    private final AnnounceService announceService;

    /**
     * Read All Page
     */
    @GetMapping("/announce")
    public String getAllAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAllAnnounce(pageable);
        model.addAttribute("announceList", announceList);

        return "announce";
    }

    /**
     * Read One Page
     */
    @GetMapping("/announce/{id}")
    public String getAnnounce(Model model, @PathVariable("id") Long id) {
        model.addAttribute("announce", announceService.getAnnounce(id));
        return "announce_detail";
    }

    /**
     * Read All Announce Page for Admin
     */
    @GetMapping("/admin/announce")
    public String manageAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAllAnnounce(pageable);
        model.addAttribute("announceList", announceList);
        return "admin_announce";
    }

    /**
     * Write Announce Page for Admin
     */
    @GetMapping("/admin/announce/form")
    public String writeAnnouncePage(WriteAnnounceReq writeAnnounceReq){
        return "admin_announce_add";
    }

    /**
     * Write Announce Service for Admin
     */
    @PostMapping("/admin/announce")
    public String writeAnnounce(WriteAnnounceReq writeAnnounceReq) {
        try {
            String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
            writeAnnounceReq.setWriter_login_id(login_id);
            announceService.write(writeAnnounceReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/announce";
    }

    /**
     * Update Announce Page for Admin
     */
    @GetMapping("admin/announce/{id}/form")
    public String UpdateAnnouncePage(@PathVariable (value="id") long id, WriteAnnounceReq writeAnnounceReq, Model model){
        model.addAttribute("announce", announceService.getAnnounce(id));
        model.addAttribute("id", id);
        return "admin_announce_update";
    }

    /**
     * Update Announce Service for Admin
     */
    @PostMapping("admin/announce/{id}")
    public String updateAnnounce(@PathVariable (value="id") long id, WriteAnnounceReq writeAnnounceReq) throws IOException {
        announceService.updateAnnounce(writeAnnounceReq,id);
        return "redirect:/admin/announce";
    }

    /**
     * Delete Announce Service for Admin
     */
    @GetMapping("admin/announce/{id}")
    public String deleteAnnounce(@PathVariable(value = "id") long id, Model model){
        announceService.deleteAnnounce(id);
        return "redirect:/admin/announce";
    }

}
