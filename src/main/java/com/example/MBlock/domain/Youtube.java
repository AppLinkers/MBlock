package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import lombok.*;

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

    private boolean onAir;

    private String API_KEY;

    private String SECRET_KEY;

    @Builder
    public Youtube(String title, String url, String imgUrl, boolean onAir) {
        this.title = title;
        this.url = url;
        this.imgUrl = imgUrl;
        this.onAir = onAir;
    }
}
