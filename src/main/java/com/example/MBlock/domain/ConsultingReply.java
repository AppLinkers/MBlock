package com.example.MBlock.domain;

import com.example.MBlock.domain.listener.Auditable;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ConsultingReply extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Consulting.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "consulting_id")
    private Consulting consulting;

    private String content;

    @Builder
    public ConsultingReply(User user, Consulting consulting, String content) {
        this.user = user;
        this.consulting = consulting;
        this.content = content;
    }
}
