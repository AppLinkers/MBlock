package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Role;
import com.example.MBlock.dto.userAuth.UserSignUpReq;
import com.example.MBlock.dto.userAuth.UserSignUpRes;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserSignUpRes signUp(UserSignUpReq request){
        validateDuplicated(request.getUsername());

        User user = User.sign_up()
                .user_id(request.getUsername())
                .user_pw(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(request.getRole()))
                .build();

        User saved_user = userRepository.save(user);

        return UserSignUpRes.builder()
                .id(saved_user.getId())
                .user_id(saved_user.getUser_id())
                .build();
    }

    public void validateDuplicated(String user_id) {
        if (userRepository.findByUser_id(user_id).isPresent()) {
            throw new RuntimeException();
        }
    }
}
