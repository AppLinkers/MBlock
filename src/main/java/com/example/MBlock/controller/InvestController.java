package com.example.MBlock.controller;

import com.example.MBlock.domain.type.TradingSite;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.dto.CurrencyInfo.AddCurrencyInfo;
import com.example.MBlock.dto.CurrencyInfo.GetCurrencyInfoRes;
import com.example.MBlock.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class InvestController {

    private final AdminService adminService;


    @GetMapping("/invest/add/{site}")
    public String goToAddInvest(@PathVariable (value="site") TradingSite tradingSite, AddCurrencyInfo addCurrencyInfo, Model model){
        model.addAttribute("tradingSite",tradingSite);
        return "admin_invest_add";
    }


    @PostMapping("/invest/add/{site}")
    public String addInvestCoin(@PathVariable (value="site") TradingSite tradingSite, AddCurrencyInfo request) throws IOException {
        request.setTradingSite(tradingSite);
        adminService.addCoin(request);
        return "redirect:/admin/invest";
    }

    @GetMapping("/invest/delete/{id}")
    public String deleteInvestCoin(@PathVariable(value = "id") long id, Model model){
        adminService.deleteAnnounce(id);
        return "redirect:/admin/invest";
    }
}