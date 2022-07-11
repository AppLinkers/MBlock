package com.example.MBlock.controller;

import com.example.MBlock.dto.UserAuth.ChangeUserRoleReq;
import com.example.MBlock.dto.UserAuth.UserLoginReq;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.dto.UserAuth.UserUpdateReq;
import com.example.MBlock.service.UserAuthService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService userService;
    private final UserAuthService userAuthService;

    /**
     * Register Page
     */
    @GetMapping("/register/form")
    public String registerPage(UserSignUpReq userSignUpReq) {
        return "register";
    }

    /**
     * Register Service
     */
    @PostMapping("/register")
    public String register(UserSignUpReq userSignUpReq) {
        try {
            userAuthService.signUp(userSignUpReq);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/login";
    }

    /**
     * Login Page
     */
    @GetMapping("/login")
    public String loginPage(UserLoginReq userLoginReq) {
        return "login";
    }

    /**
     * Logout Service
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }


    /**
     * Read All User Page
     */
    @GetMapping("/admin/member")
    public String getUserAll(Model model) {
        model.addAttribute("userList", userService.getUserInfoAll());
        return "admin_member";
    }

    /**
     * Update User Page
     */
    @GetMapping("admin/member/{id}/form")
    public String memberUpdate(@PathVariable(value = "id") Long id, Model model, UserUpdateReq userUpdateReq){
        model.addAttribute("member", userService.getUserById(id));
        model.addAttribute("id", id);
        return "admin_member_detail";
    }

    /**
     * Update User Service
     */
    @PostMapping("admin/member/{id}")
    public String updateMember(@PathVariable (value="id") long id, UserUpdateReq userUpdateReq) throws IOException {
        userService.updateMember(userUpdateReq,id);
        return "redirect:/admin/member";
    }

    /**
     * Update User Role Service
     */
    @PostMapping("admin/member/{id}/role")
    public String updateMemberStatus(@PathVariable (value="id") String id, ChangeUserRoleReq request) {
        request.setUserLoginId(id);
        request.setRole("ACCEPTED");
        userAuthService.changeUserStatue(request);
        return "redirect:/admin/member";
    }

    /**
     * /delete 제거
     * Delete User Service
     */
    @GetMapping("admin/member/{id}")
    public String deleteMember(@PathVariable(value = "id") long id, Model model){
        userService.deleteMember(id);
        return "redirect:/admin/member";
    }
}
