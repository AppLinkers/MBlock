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
public class Consulting extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String context;

    private String trader;

    @Builder
    public Consulting(String name, String email, String phone, String context, String trader) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.context = context;
        this.trader = trader;
    }
}
