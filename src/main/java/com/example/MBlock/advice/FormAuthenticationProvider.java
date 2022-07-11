package com.example.MBlock.advice;

import com.example.MBlock.domain.UserDetail;
import com.example.MBlock.domain.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FormAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetail userDetail = (UserDetail) userDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, userDetail.getPassword())) {
            throw new BadCredentialsException("invalid");
        }

        if (userDetail.getAuthorities().contains(new SimpleGrantedAuthority(Role.PENDING.toString()))) {
            throw new InsufficientAuthenticationException("unauthorized");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetail.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
