package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.domain.type.Role;
import com.example.MBlock.domain.type.UserStatus;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_id;

    private String name;

    private String user_pw;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String profile_img;

    @Builder
    public User(String user_id, String user_pw, Role role) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.role = role;
    }
}
