package com.example.MBlock.domain;

import com.example.MBlock.domain.listener.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Announce extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String user_name;

    private String context;

    private String file_url;

    @Builder
    public Announce(String title, String user_name, String context) {
        this.title = title;
        this.user_name = user_name;
        this.context = context;
    }
}
