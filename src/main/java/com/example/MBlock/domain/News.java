package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.support.BooleanToYNConverter;
import lombok.*;
import org.springframework.lang.Nullable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class News extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String context;

    @Nullable
    private String imgUrl;

    private Integer viewCount = 0;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean isMain = false;

    @Builder
    public News(User user, String title, String context, @Nullable String imgUrl) {
        this.user = user;
        this.title = title;
        this.context = context;
        this.imgUrl = imgUrl;
    }
}
