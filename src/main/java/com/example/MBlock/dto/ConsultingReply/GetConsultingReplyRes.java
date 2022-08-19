package com.example.MBlock.dto.ConsultingReply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetConsultingReplyRes {

    private Long id;

    private Long consulting_id;

    private Long writer_id;

    private String writer_name;

    private String writer_profile_img;

    private String content;
}
