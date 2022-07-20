package com.example.MBlock.dto.CurrencyInfo;

import com.example.MBlock.domain.type.TradingSite;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class AddCurrencyInfo {

    private String code;

    private String name;

    private Optional<MultipartFile> imgFile;

    private TradingSite tradingSite;
}
