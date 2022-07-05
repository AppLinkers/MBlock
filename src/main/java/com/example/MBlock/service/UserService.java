package com.example.MBlock.service;

import com.example.MBlock.domain.Announce;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Approved;
import com.example.MBlock.dto.Announce.GetAnnounceRes;
import com.example.MBlock.dto.User.GetUserInfoRes;
import com.example.MBlock.dto.User.GetUserProfileRes;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public GetUserInfoRes getUserById(long id){

        User user = userRepository.findById(id).get();

        return GetUserInfoRes.builder()
                .name(user.getName())
                .id(user.getId())
                .role(user.getRole())
                .phone(user.getPhone())
                .profile_img(user.getProfile_img())
                .build();
    }

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

    @Modifying
    public void deleteMember(Long memberId) {
        User user = userRepository.findById(memberId).get();
            userRepository.delete(user);
    }

    public List<GetUserInfoRes> getUserInfoAll() {
        List<GetUserInfoRes> result = new ArrayList<>();

        List<User> userList = userRepository.findAll();

        userList.forEach(
                u -> {
                    result.add(GetUserInfoRes.builder()
                            .id(u.getId())
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
