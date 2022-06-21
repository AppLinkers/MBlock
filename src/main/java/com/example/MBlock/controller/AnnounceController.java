package com.example.MBlock.controller;

import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.Announce.WriteAnnounceReq;
import com.example.MBlock.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AnnounceController {

    private final AnnounceService announceService;

    @GetMapping("/announce")
    public String getAnnounce(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<GetAnnounceRes> announceList = announceService.getAnnounceAll(pageable);

        model.addAttribute("announceList", announceList);

        return "announce";
    }

    @RequestMapping(value = "/announce", method = RequestMethod.GET, params = "id")
    @ResponseBody
    public String getAnnounceOne(Model model, @RequestParam("id") Long id) {
        System.out.println(announceService.getAnnounce(id).toString());

        model.addAttribute("announce", announceService.getAnnounce(id));

        return "test";
    }

    // write Announce
    @PostMapping("/announce")
    public void writeAnnounce(WriteAnnounceReq request) {
        try {
            announceService.write(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
