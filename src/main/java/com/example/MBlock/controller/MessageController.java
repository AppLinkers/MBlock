package com.example.MBlock.controller;

import com.example.MBlock.dto.Message.MessageReq;
import com.example.MBlock.service.MessageService;
import com.example.MBlock.service.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    private final S3Uploader s3Uploader;

    /**
     * Admin Chat Page
     */
    @GetMapping("/admin/chat")
    public String adminChat(Model model) {
        String userLoginId = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("userLoginId", userLoginId);
        model.addAttribute("userList", messageService.findUserByRoomId(0L));
        model.addAttribute("messageList", messageService.findByRoomId(0L));

        return "admin_chat";
    }

    /**
     * Send Message Service
     */
    @MessageMapping("/message")
    public void message(MessageReq message) {
        messageService.send(message);
    }

    @ResponseBody
    @PostMapping("/message/img")
    public String chatImg(@ModelAttribute("image") MultipartFile image) throws IOException {
        if (image != null) {
            return s3Uploader.upload(image, "chat");
        } else {
            throw new RuntimeException();
        }
    }
}
