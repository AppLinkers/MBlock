package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Approved;
import com.example.MBlock.dto.User.GetUserInfoRes;
import com.example.MBlock.dto.User.GetUserProfileRes;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Read All
    public List<GetUserProfileRes> getUserProfileAll() {
        List<GetUserProfileRes> result = new ArrayList<>();

        Optional<List<User>> userList = userRepository.findUserByApprovedIs(Approved.ACCEPTED);

        userList.ifPresent(users -> users.forEach(
                u -> {
                    result.add(GetUserProfileRes.builder()
                            .name(u.getName())
                            .role(u.getRole())
                            .imgUrl(u.getProfile_img())
                            .build());
                }
        ));

        return result;
    }

    public List<GetUserInfoRes> getUserInfoAll() {
        List<GetUserInfoRes> result = new ArrayList<>();

        List<User> userList = userRepository.findAll();

        userList.forEach(
                u -> {
                    result.add(GetUserInfoRes.builder()
                            .login_id(u.getLogin_id())
                            .name(u.getName())
                            .role(u.getRole())
                            .phone(u.getPhone())
                            .approved(u.getApproved().toString())
                            .profile_img(u.getProfile_img()).build());
                }
        );

        return result;
    }

}
