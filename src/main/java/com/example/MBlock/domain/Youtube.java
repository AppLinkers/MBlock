package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.support.BooleanToYNConverter;
import com.example.MBlock.support.CryptoConverter;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Youtube extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    private String imgUrl;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean onAir;

    private String apiKey;

    @Convert(converter = CryptoConverter.class)
    private Optional<String> secretKey;

    @Builder
    public Youtube(String title, String url, String imgUrl, boolean onAir) {
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
        this.onAir = onAir;
    }
}
