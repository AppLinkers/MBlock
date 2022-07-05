package com.example.MBlock.domain;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imgUrl;

    @Builder
    public Partner(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }
}
