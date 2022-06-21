package com.example.MBlock.controller;

import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.UserAuth.UserLoginReq;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.service.AnnounceService;
import com.example.MBlock.service.UserAuthService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final AnnounceService announceService;
    private final UserService userService;

    @GetMapping("/register")
    public String getRegisterForm(UserSignUpReq userSignUpReq) {
        return "register";
    }



    @PostMapping("/register")
    public String register(UserSignUpReq userSignUpReq) {
        try {
            userAuthService.signUp(userSignUpReq);
        } catch (IOException e) {
            // image upload 실패
            e.printStackTrace();
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginForm(UserLoginReq userLoginReq) {
        return "login";
    }

    @GetMapping("/main")
    public String main(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }

    @GetMapping("/user")
    public String user(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "user";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "admin";
    }


    //admin page controller

    @GetMapping("/admin/memberManage")
    public String manageUser(Model model) {
        model.addAttribute("userList", userService.getUserInfoAll());
        return "memberManage";
    }

    @GetMapping("/admin/announce")
    public String manageAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAnnounceAll(pageable);
        model.addAttribute("announceList", announceList);
        return "admin_announce";
    }

    @GetMapping("/admin/news")
    public String manageNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return "admin_news";
    }

    @GetMapping("/admin/invest")
    public String manageInvest(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return "admin_invest";
    }

    @GetMapping("/admin/consult")
    public String manageConsult(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return "admin_consult";
    }



}
