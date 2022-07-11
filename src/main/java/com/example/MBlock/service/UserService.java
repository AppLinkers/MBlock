package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Role;
import com.example.MBlock.dto.User.GetUserInfoRes;
import com.example.MBlock.dto.User.GetUserProfileRes;
import com.example.MBlock.dto.UserAuth.UserUpdateReq;
import com.example.MBlock.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    public GetUserInfoRes getUserById(long id){

        User user = userRepository.findById(id).get();

        return GetUserInfoRes.builder()
                .name(user.getName())
                .login_id(user.getLogin_id())
                .position(user.getPosition())
                .phone(user.getPhone())
                .profile_img(user.getProfile_img())
                .role(user.getRole().toString())
                .build();
    }


    @Transactional
    public void updateMember(UserUpdateReq request, Long memberId) throws IOException {
        User user = userRepository.findById(memberId).get();

        user.setRole(request.getRole());
        user.setPosition(request.getPosition());
        user.setPhone(request.getPhone());

        if (request.getProfile_img() != null) {
            String imgUrl = s3Uploader.upload(request.getProfile_img().get(), "member");
            user.setProfile_img(imgUrl);
        }
        userRepository.save(user);
    }

    // Read All
    public List<GetUserProfileRes> getUserProfileAll() {
        List<GetUserProfileRes> result = new ArrayList<>();

        Optional<List<User>> userList = userRepository.findUserByRoleIs(Role.ACCEPTED);

        userList.ifPresent(users -> users.forEach(
                u -> {
                    result.add(GetUserProfileRes.builder()
                            .name(u.getName())
                            .position(u.getPosition())
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
                            .position(u.getPosition())
                            .phone(u.getPhone())
                            .role(u.getRole().toString())
                            .profile_img(u.getProfile_img()).build());
                }
        );

        return result;
    }

}
