package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
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

    @Builder
    public News(User user, String title, String context, @Nullable String imgUrl) {
        this.user = user;
        this.title = title;
        this.context = context;
        this.imgUrl = imgUrl;
    }
}
