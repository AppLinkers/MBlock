package com.example.MBlock.controller;

import com.example.MBlock.dto.Youtube.WriteYoutubeReq;
import com.example.MBlock.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String manageYoutube() {
        return "admin_youtube";
    }

    /**
     * Write Youtube Page for Admin
     */
    @GetMapping("/admin/youtube/form")
    public String writeYoutubePage(WriteYoutubeReq writeYoutubeReq){
        return "admin_youtube_add";
    }

    /**
     * Write Youtube Service for Admin
     */
    @PostMapping("/admin/youtube")
    public String writeYoutube(WriteYoutubeReq writeYoutubeReq) {
        try {
            youtubeService.save(writeYoutubeReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/youtube";
    }
}
