package com.example.MBlock.domain.type;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Role {
    PENDING,
    ACCEPTED,
    SYSTEM

}