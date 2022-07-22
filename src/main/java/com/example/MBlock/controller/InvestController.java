package com.example.MBlock.controller;

import com.example.MBlock.dto.CurrencyInfo.AddCurrencyInfo;
import com.example.MBlock.service.AdminService;
import com.example.MBlock.service.NewsService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class InvestController {

    private final UserService userService;
    private final AdminService adminService;
    private final NewsService newsService;


    @GetMapping("/invest/add/{tradeSite}")
    public String goToInvestAdd(@PathVariable(value = "tradeSite") String site, Model model, AddCurrencyInfo request){
        model.addAttribute("site",site);
        return "admin_invest_add";
    }


    //add invest coin
    @PostMapping("/invest/add")
    public String addInvestCoin(AddCurrencyInfo request) throws IOException {
        adminService.addCoin(request);
        return "redirect:/admin/invest";
    }

    //delete invest coin
    @GetMapping("/invest/delete/{id}")
    public String deleteInvestCoin(@PathVariable(value = "id") long id, Model model){
        adminService.deleteAnnounce(id);
        return "redirect:/admin/invest";
    }
}
