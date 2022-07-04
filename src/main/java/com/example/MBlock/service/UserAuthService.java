package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Approved;
import com.example.MBlock.dto.UserAuth.ChangeUserApprovedReq;
import com.example.MBlock.dto.UserAuth.UserSignUpReq;
import com.example.MBlock.dto.UserAuth.UserSignUpRes;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final S3Uploader s3Uploader;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserSignUpRes signUp(UserSignUpReq request) throws IOException {
        validateDuplicated(request.getLoginId());

        String imgUrl = s3Uploader.upload(request.getProfileImg(), "profile");

        User user = User.builder()
                .login_id(request.getLoginId())
                .login_pw(passwordEncoder.encode(request.getLoginPw()))
                .name(request.getName())
                .role(request.getRole())
                .phone(request.getPhone())
                .profile_img(imgUrl)
                .build();

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

    @Transactional
    public void changeUserStatue(ChangeUserApprovedReq request) {

        User user = userRepository.findByUser_id(request.getUserLoginId()).get();

        user.setApproved(Approved.valueOf(request.getApproved()));

        userRepository.save(user);
    }
}
