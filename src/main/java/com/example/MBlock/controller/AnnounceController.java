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

    @GetMapping("/announce")
    public String getAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAnnounceAll(pageable);

        model.addAttribute("announceList", announceList);

        return "announce";
    }

    @RequestMapping(value = "/announce", method = RequestMethod.GET, params = "id")
    public String getAnnounceOne(Model model, @RequestParam("id") Long id) {
        model.addAttribute("announce", announceService.getAnnounce(id));
        return "announce_detail";
    }

    // write Announce
    @PostMapping("/announce")
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


    @GetMapping("/announce/add")
    public String goToAddAnnounce(WriteAnnounceReq writeAnnounceReq){
        return "admin_announce_add";
    }


  //  @RequestMapping(value = "/announce/update", method = RequestMethod.GET, params = "id")
    @GetMapping("/announce/update/{id}")
    public String goToUpdateAnnounce(@PathVariable (value="id") long id,Model model){
        model.addAttribute("announce", announceService.getAnnounce(id));
        model.addAttribute("id", id);
        return "admin_announce_update";
    }

    @GetMapping("/announce/delete/{id}")
    public String deleteAnnounce(@PathVariable(value = "id") long id, Model model){
        String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
        announceService.deleteAnnounce(id,login_id);
        return "redirect:/admin/announce";
    }

    @PostMapping("announce/update/{id}")
    public String updateAnnounce(@PathVariable (value="id") long id, @ModelAttribute("announce") WriteAnnounceReq writeAnnounceReq) throws IOException {
        announceService.updateAnnounce(writeAnnounceReq,id);
        return "redirect:/admin/announce";
    }



}
