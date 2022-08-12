package com.example.MBlock.dto.ConsultingReply;

import lombok.Data;

@Data
public class WriteConsultingReplyReq {

    private Long consulting_id;

    private Long user_id;

    private String content;
}
