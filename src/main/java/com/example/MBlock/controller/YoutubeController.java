package com.example.MBlock.controller;

import com.example.MBlock.dto.Youtube.GetYoutubeRes;
import com.example.MBlock.dto.Youtube.UpdateYoutubeReq;
import com.example.MBlock.dto.Youtube.WriteYoutubeReq;
import com.example.MBlock.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class YoutubeController {

    private final YoutubeService youtubeService;

    /**
     * Read All Youtube Page for Admin
     */
    @GetMapping("/admin/youtube")
    public String manageYoutube(Model model, UpdateYoutubeReq updateYoutubeReq , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetYoutubeRes> youtubeList = youtubeService.getAllYoutuber(pageable);
        model.addAttribute("youtubeList", youtubeList);
        return "admin_youtube";
    }


    /**
     * Write Youtube Page for Admin
     */
    @GetMapping("/admin/youtube/form")
    public String writeYoutubePage( WriteYoutubeReq writeYoutubeReq){

        return "admin_youtube_add";
    }

    /**
     * Write Youtube Service for Admin
     */
    @PostMapping("/admin/youtube")
    public String writeYoutube(WriteYoutubeReq writeYoutubeReq) {
        try {
            System.out.println(writeYoutubeReq.getImgFile());
            youtubeService.save(writeYoutubeReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/youtube";
    }



    /**
     * Write Youtube Service for Admin
     */
    @PostMapping("/youtube/edit")
    public String editOnAir(UpdateYoutubeReq updateYoutubeReq) {
        youtubeService.updateYoutube(updateYoutubeReq);
        return "redirect:/admin/youtube";
    }

}
