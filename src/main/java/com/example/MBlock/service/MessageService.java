package com.example.MBlock.service;

import com.example.MBlock.domain.Message;
import com.example.MBlock.domain.Room;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.UserAndRoom;
import com.example.MBlock.domain.type.MessageType;
import com.example.MBlock.dto.Message.MessageReq;
import com.example.MBlock.dto.Message.MessageRes;
import com.example.MBlock.dto.User.GetUserProfileRes;
import com.example.MBlock.repository.MessageRepository;
import com.example.MBlock.repository.RoomRepository;
import com.example.MBlock.repository.UserAndRoomRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final RoomRepository roomRepository;

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    private final SimpMessageSendingOperations messagingTemplate;

    @Transactional
    public void send(MessageReq request) {

        User user = userRepository.findByUser_id(request.getUser_login_id()).get();
        Room room = roomRepository.findById(request.getRoomId()).get();

        Message message = new Message();

        message.setMessageType(request.getMessageType());
        message.setRoom(room);
        message.setUser(user);

        if (message.getMessageType().equals(MessageType.TALK) || message.getMessageType().equals(MessageType.TALK)) {
            message.setMessage(request.getMessage());

            messageRepository.save(message);

            MessageRes messageRes = MessageToMessageRes(message);

            messagingTemplate.convertAndSend("/sub/chat/room/" + messageRes.getRoomId(), messageRes);
        }
    }

    public List<MessageRes> findByRoomId(Long room_id) {
        List<MessageRes> result = new ArrayList<>();

        Optional<List<Message>> messageList = messageRepository.findByRoom(roomRepository.getById(room_id));

        messageList.ifPresent(messages -> messages.forEach(
                message -> {
                    result.add(MessageToMessageRes(message));
                }
        ));

        return result;
    }

    public List<GetUserProfileRes> findUserByRoomId(Long room_id) {
        List<GetUserProfileRes> result = new ArrayList<>();

        Room room = roomRepository.findById(room_id).get();

        room.getUserAndRoomList().forEach(
                userAndRoom -> {
                    User user = userAndRoom.getUser();
                    result.add(GetUserProfileRes.builder().name(user.getName()).role(user.getRole()).imgUrl(user.getProfile_img()).build());
                }
        );

        return result;
    }

    private MessageRes MessageToMessageRes(Message message) {
        return MessageRes.builder()
                .messageType(message.getMessageType())
                .roomId(message.getRoom().getId())
                .userLoginId(message.getUser().getLogin_id())
                .userName(message.getUser().getName())
                .userProfileImg(message.getUser().getProfile_img())
                .message(message.getMessage())
                .build();
    }
}
