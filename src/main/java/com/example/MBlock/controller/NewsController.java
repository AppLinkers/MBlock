package com.example.MBlock.controller;

import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.dto.News.SetMainNewsReq;
import com.example.MBlock.dto.News.WriteNewsReq;
import com.example.MBlock.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    /**
     * Read All Page
     */
    @GetMapping("/news")
    public String getAllNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<GetNewsRes> newsList = newsService.getAllNews(pageable);
        GetNewsRes mainNews = newsService.getMainNews();
        model.addAttribute("newsList", newsList);
        model.addAttribute("mainNews", mainNews);
        return "news";
    }

    /**
     * Read One Page
     */
    @GetMapping("/news/{id}")
    public String getNews(Model model, @PathVariable("id") Long id) {
        model.addAttribute("news", newsService.getNews(id));
        model.addAttribute("topNews", newsService.getTop3News());
        return "news_detail";
    }

    /**
     * Read All Page for Admin
     */
    @GetMapping("/admin/news")
    public String manageNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<GetNewsRes> newsList = newsService.getAllNews(pageable);
        model.addAttribute("newsList", newsList);
        return "admin_news";
    }

    /**
     * Write News Page for Admin
     */
    @GetMapping("/admin/news/form")
    public String addNews(WriteNewsReq writeNewsReq) {
        return "admin_news_add";
    }

    /**
     * Write News Service for Admin
     */
    @PostMapping("/admin/news")
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

    /**
     * Update New Page for Admin
     */
    @GetMapping("/admin/news/{id}/form")
    public String updateNewsPage(@PathVariable(value = "id") long id, Model model, WriteNewsReq writeNewsReq) {
        model.addAttribute("news", newsService.getNews(id));
        model.addAttribute("id", id);
        return "admin_news_update";
    }


    /**
     * Update News Service for Admin
     */
    @PostMapping("/admin/news/{id}")
    public String updateNews(@PathVariable(value = "id") long id, WriteNewsReq writeNewsReq) throws IOException {
        newsService.updateNews(writeNewsReq, id);
        return "redirect:/admin/news";
    }

    /**
     * Delete News Service for Admin
     */
    @GetMapping("admin/news/{id}")
    public String deleteNews(@PathVariable(value = "id") long id, Model model){
        newsService.deleteNews(id);
        return "redirect:/admin/news";
    }

    /**
     * Set Main News Service for Admin
     */
    @GetMapping("admin/news/main/{id}")
    public String setMainNews(@PathVariable(value = "id") Long id) {
        newsService.setMainNews(id);
        return "redirect:/admin/news";
    }

}
