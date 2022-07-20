package com.example.MBlock.dto.CurrencyInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCurrencyInfoRes {

    private String code;

    private String name;

    private String imgUrl;

    private String tradingSite;
}
