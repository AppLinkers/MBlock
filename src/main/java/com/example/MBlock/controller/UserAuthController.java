package com.example.MBlock.controller;

import com.example.MBlock.dto.UserAuth.UserLoginReq;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.service.UserAuthService;
import lombok.RequiredArgsConstructor;
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


    //controller 분할 필요
    @GetMapping("/news")
    public String getNews(){return "news";}

    @GetMapping("/invest")
    public String getInvest(){return "invest";}


    @GetMapping("/announce")
    public String getAnnounce(){return "announce";}

    @GetMapping("/contact")
    public String getContact(){return "contact";}

    @GetMapping("/consulting")
    public String getConsulting(){return "consulting";}

    @GetMapping("/business")
    public String getBusiness(){return "business";}
}
