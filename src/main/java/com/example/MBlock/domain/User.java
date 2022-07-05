package com.example.MBlock.domain;

import javax.persistence.*;

import com.example.MBlock.domain.listener.Auditable;
import com.example.MBlock.domain.type.Approved;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    private String role;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Approved approved = Approved.PENDING;

    private String profile_img;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAndRoom> userAndRoomList = new ArrayList<>();

    @Builder
    public User(String login_id, String login_pw, String name, String role, String phone, String profile_img) {
        this.login_id = login_id;
        this.login_pw = login_pw;
        this.name = name;
        this.role = role;
        this.phone = phone;
        this.profile_img = profile_img;
    }
}
