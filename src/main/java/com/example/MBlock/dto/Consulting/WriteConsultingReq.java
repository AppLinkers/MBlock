package com.example.MBlock.dto.Consulting;
import lombok.Data;

@Data
public class WriteConsultingReq {

    private String name;

    private String email;

    private String phone;

    private String context;

    private String trader;

    private boolean privacy;


}
