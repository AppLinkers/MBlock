package com.example.MBlock.dto.Message;

import com.example.MBlock.domain.type.MessageType;
import lombok.Builder;
import lombok.Data;


@Data
public class MessageReq {

    private MessageType messageType; // 생성 및 입장 / 퇴장 / 일반 채팅 / 이미지 채팅 구분

    private Long roomId; // 전송 채팅방

    private String user_login_id; // 전송자 id

    private String message; // 채팅 본문

    @Builder
    public MessageReq(MessageType messageType, Long roomId, String user_login_id, String message) {
        this.messageType = messageType;
        this.roomId = roomId;
        this.user_login_id = user_login_id;
        this.message = message;
    }
}
