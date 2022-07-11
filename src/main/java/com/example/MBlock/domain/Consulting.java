package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.support.BooleanToYNConverter;
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

    @Convert(converter = BooleanToYNConverter.class)
    private boolean privacy;

    @Convert(converter = BooleanToYNConverter.class)
    private boolean replied;

    @Builder
    public Consulting(String name, String email, String phone, String context, String trader, boolean privacy, boolean replied) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.context = context;
        this.trader = trader;
        this.privacy=privacy;
        this.replied = replied;
    }
}
