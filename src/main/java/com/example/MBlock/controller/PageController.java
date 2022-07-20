package com.example.MBlock.controller;

import com.example.MBlock.dto.CurrencyInfo.AddCurrencyInfo;
import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.service.AdminService;
import com.example.MBlock.service.NewsService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;
    private final AdminService adminService;
    private final NewsService newsService;

    /**
     * Main Page
     */
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
        return "redirect:/";
    }

    /**
     * Invest Page
     */
    @GetMapping("/invest")
    public String investPage(Model model) {
        model.addAttribute("upBitList", adminService.getCurrencyInfoResAllOfTradingSite("UPBIT"));
        return "invest";
    }

    @PostMapping("/invest/add")
    public String addInvestCoin(AddCurrencyInfo request) throws IOException {
        adminService.addCoin(request);
        return "redirect:/admin/invest";
    }

    /**
     * Contact Page
     */
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    /**
     * Business Page
     */
    @GetMapping("/business")
    public String businessPage(Model model) {
        model.addAttribute("userList", userService.getUserProfileAll());
        model.addAttribute("partnerList", adminService.getPartnerAll());
        model.addAttribute("binanceList", adminService.getCurrencyInfoResAllOfTradingSite("BINANCE"));

        return "business";
    }

    /**
     * 어떤 Page??
     */
    @GetMapping("/user")
    public String user(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "user";
    }

    /**
     * Admin Page for Admin
     */
    @GetMapping("/admin")
    public String admin(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("name", name);
        return "admin";
    }

    /**
     * Read All Invest Page for Admin
     */
    @GetMapping("/admin/invest")
    public String manageInvest(Model model) {
        return "admin_invest";
    }


    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
}
