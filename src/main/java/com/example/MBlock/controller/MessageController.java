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

    @GetMapping("/admin/chat")
    public String manageChat(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<MessageRes> messageList = messageService.findByRoomId(0L);

        model.addAttribute("userLoginId", name);
        model.addAttribute("userList", messageService.findUserByRoomId(0L));
        model.addAttribute("messageList", messageList);

        return "admin_chat";
    }

    @MessageMapping("/message")
    public void message(MessageReq message) {
        messageService.send(message);
    }
}
