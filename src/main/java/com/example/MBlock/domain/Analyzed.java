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
public class Analyzed extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String user_name;

    private String context;

    private String file_url;

    @Builder
    public Analyzed(String title, String user_name, String context) {
        this.title = title;
        this.user_name = user_name;
        this.context = context;
    }
}
