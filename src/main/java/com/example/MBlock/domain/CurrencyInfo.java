package com.example.MBlock.domain;

import com.example.MBlock.domain.type.TradingSite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @Nullable
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private TradingSite tradingSite;


    @Builder
    public CurrencyInfo(String code, String name, String imgUrl, TradingSite tradingSite){
        this.code =code;
        this.name = name;
        this.imgUrl = imgUrl;
        this.tradingSite = tradingSite;
    }

}