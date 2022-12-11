package team.spacechat.spacechatapi.chatroom.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatRoom {

    String chatRoomId;
    String postId;
    String joinerId;
    LocalDateTime createdAt;

}
