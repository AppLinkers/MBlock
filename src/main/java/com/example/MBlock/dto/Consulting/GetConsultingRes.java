package com.example.MBlock.dto.Consulting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetConsultingRes {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String context;

    private String trader;

    private boolean replied;

    private String datetime;

}
