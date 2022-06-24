package com.example.MBlock.controller;

import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.dto.News.WriteNewsReq;
import com.example.MBlock.service.NewsService;
import com.example.MBlock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public String getNews(){return "news";}

    @GetMapping("/admin/news")
    public String manageNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<GetNewsRes> newsList = newsService.getAllNews(pageable);
        model.addAttribute("newsList",newsList);
        return "admin_news";
    }

    @GetMapping("/admin/news/add")
    public String addNews(WriteNewsReq writeNewsReq){
        return "admin_news_add";
    }

    // write Announce
    @PostMapping("/news")
    public String writeNews(WriteNewsReq writeNewsReq) {
        try {
            String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
            writeNewsReq.setWriter_login_id(login_id);
            newsService.write(writeNewsReq);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/news";
    }
}
