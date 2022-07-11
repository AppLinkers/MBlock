package com.example.MBlock.controller;

import com.example.MBlock.dto.Message.MessageReq;
import com.example.MBlock.dto.Message.MessageRes;
import com.example.MBlock.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

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
}
