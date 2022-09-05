package com.example.MBlock.controller;

import com.example.MBlock.domain.CurrencyInfo;
import com.example.MBlock.dto.CurrencyInfo.GetCurrencyInfoRes;
import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.service.AdminService;
import com.example.MBlock.service.NewsService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/nav")
    public String nav(Model model){
        return "nav";
    }

    @GetMapping("/footer")
    public String footer(Model model){
        return "footer";
    }

    @GetMapping("/brand")
    public String brand(Model model){
        return "brand";
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
        model.addAttribute("binanceList", adminService.getCurrencyInfoResAllOfTradingSite("BINANCE"));

        return "invest";
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
        List<GetCurrencyInfoRes> upbitCoin = adminService.getCurrencyInfoResAllOfTradingSite("UPBIT");
        List<GetCurrencyInfoRes> binanceCoin = adminService.getCurrencyInfoResAllOfTradingSite("BINANCE");
        model.addAttribute("upbitCoin", upbitCoin);
        model.addAttribute("binanceCoin",binanceCoin);
        return "admin_invest";
    }


    @GetMapping("/test")
    public String testPage() {
        return "test_bitGet";
    }
}
