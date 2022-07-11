package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.domain.type.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    private String login_id;

    private String login_pw;

    private String name;

    private String position;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role = Role.PENDING;

    @Nullable
    private String profile_img;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAndRoom> userAndRoomList = new ArrayList<>();

    @Builder
    public User(String login_id, String login_pw, String name, String position, String phone, String profile_img) {
        this.login_id = login_id;
        this.login_pw = login_pw;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.profile_img = profile_img;
    }
}
