package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.dto.UserAuth.UserSignUpRes;
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
        validateDuplicated(request.getLoginId());

        User user = new User();

        User saved_user = userRepository.save(user);

        return UserSignUpRes.builder()
                .id(saved_user.getId())
                .loginId(saved_user.getLogin_id())
                .build();
    }

    public void validateDuplicated(String user_id) {
        if (userRepository.findByUser_id(user_id).isPresent()) {
            throw new RuntimeException();
        }
    }
}
