package com.example.MBlock.domain;

import com.example.MBlock.domain.type.TradingSite;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private TradingSite tradingSite;

}