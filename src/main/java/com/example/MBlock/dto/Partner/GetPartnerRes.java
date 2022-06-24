package com.example.MBlock.dto.Partner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPartnerRes {

    private String name;

    private String imgUrl;

}
