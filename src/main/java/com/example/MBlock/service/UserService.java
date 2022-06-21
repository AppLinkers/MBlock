package com.example.MBlock.service;

import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.Approved;
import com.example.MBlock.dto.User.GetUserRes;
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
    public List<GetUserRes> getUserAll() {
        List<GetUserRes> result = new ArrayList<>();

        Optional<List<User>> userList = userRepository.findUserByApprovedIs(Approved.ACCEPTED);

        userList.ifPresent(users -> users.forEach(
                u -> {
                    result.add(GetUserRes.builder()
                            .name(u.getName())
                            .role(u.getRole())
                            .imgUrl(u.getProfile_img())
                            .build());
                }
        ));

        return result;
    }
}
