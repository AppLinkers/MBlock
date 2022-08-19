package com.example.MBlock.dto.ConsultingReply;

import lombok.Data;

@Data
public class WriteConsultingReplyReq {

    private Long consulting_id;

    private String user_login_id;

    private String content;
}
