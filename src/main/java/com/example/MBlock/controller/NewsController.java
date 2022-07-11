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
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public String getNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<GetNewsRes> newsList = newsService.getAllNews(pageable);
        GetNewsRes mainNews = newsService.getMainNews();
        model.addAttribute("newsList", newsList);
        model.addAttribute("mainNews", mainNews);
        return "news";
    }

    @GetMapping("/admin/news")
    public String manageNews(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<GetNewsRes> newsList = newsService.getAllNews(pageable);
        model.addAttribute("newsList", newsList);
        return "admin_news";
    }

    @GetMapping("/admin/news/add")
    public String addNews(WriteNewsReq writeNewsReq) {
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

    @RequestMapping(value = "/news", method = RequestMethod.GET, params = "id")
    public String newsDetail(Model model, @RequestParam("id") Long id) {
        model.addAttribute("news", newsService.getNews(id));
        return "news_detail";
    }

    @GetMapping("/news/update/{id}")
    public String goToUpdateNews(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("news", newsService.getNews(id));
        model.addAttribute("id", id);
        return "admin_news_update";
    }


    @PostMapping("/news/update/{id}")
    public String updateNews(@PathVariable(value = "id") long id, WriteNewsReq writeNewsReq) throws IOException {
        newsService.updateNews(writeNewsReq, id);
        return "redirect:/admin/news";
    }

    @PostMapping("/news/main")
    public void setMainNews(SetMainNewsReq request) {
        newsService.setMainNews(request);

    }

    @GetMapping("news/delete/{id}")
    public String deleteNews(@PathVariable(value = "id") long id, Model model){
        newsService.deleteNews(id);
        return "redirect:/admin/news";
    }

}
