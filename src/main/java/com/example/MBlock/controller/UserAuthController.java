package com.example.MBlock.controller;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.dto.UserAuth.ChangeUserApprovedReq;
import com.example.MBlock.dto.UserAuth.UserLoginReq;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.dto.UserAuth.UserUpdateReq;
import com.example.MBlock.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final AnnounceService announceService;
    private final NewsService newsService;
    private final ConsultingService consultingService;
    private final UserService userService;
    private final AdminService adminService;

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

    @GetMapping("/")
    public String index(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<GetNewsRes> topNews = newsService.getTop3News();
        model.addAttribute("partnerList", adminService.getPartnerAll());
        model.addAttribute("topNews", topNews);
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/main")
    public String main(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<GetNewsRes> topNews = newsService.getTop3News();
        model.addAttribute("partnerList", adminService.getPartnerAll());
        model.addAttribute("topNews", topNews);
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

    @GetMapping("/admin/member")
    public String manageUser(Model model) {
        model.addAttribute("userList", userService.getUserInfoAll());
        return "admin_member";
    }

    @GetMapping("/member/update/{id}")
    public String memberUpdate(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("member", userService.getUserById(id));
        model.addAttribute("id", id);
        return "admin_member_update";
    }

    @PostMapping("/member/update/{id}")
    public String updateMember(@PathVariable (value="id") long id, @ModelAttribute("user") UserUpdateReq userUpdateReq) throws IOException{
        userService.updateMember(userUpdateReq,id);
        return "redirect:/admin/member";
    }

    @PostMapping("/member/status/{id}")
    public String updateMemberStatus(@PathVariable (value="id") String id,ChangeUserApprovedReq request) throws IOException {
        System.out.println(id);
        request.setUserLoginId(id);
        request.setApproved("ACCEPTED");
        userAuthService.changeUserStatue(request);
        return "redirect:/admin/member";
    }

    @GetMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable(value = "id") long id, Model model){
        userService.deleteMember(id);
        return "redirect:/admin/member";
    }

    @GetMapping("/admin/announce")
    public String manageAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAnnounceAll(pageable);
        model.addAttribute("announceList", announceList);
        return "admin_announce";
    }

    @GetMapping("/admin/partners")
    public String managePartners(Model model) {
        model.addAttribute("partnerList", adminService.getPartnerAll());
        return "admin_partner";
    }

    @GetMapping("/admin/invest")
    public String manageInvest(Model model) {
        return "admin_invest";
    }

    @GetMapping("/admin/consult")
    public String manageConsult(Model model) {
        List<GetConsultingRes> consultList = consultingService.getAllConsulting();
        model.addAttribute("consultList", consultList);
        return "admin_consult";
    }

    @RequestMapping(value = "/admin/consult", method = RequestMethod.GET, params = "id")
    public String consultDetail(Model model, @RequestParam("id") Long id){
        GetConsultingRes consult = consultingService.getConsulting(id);
        model.addAttribute("consult", consult);
        return "admin_consult_detail";
    }



}
