package com.example.MBlock.dto.Partner;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddPartnerReq {

    private String name;

    private MultipartFile profileImg;
}
