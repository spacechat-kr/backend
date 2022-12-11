package team.spacechat.spacechatapi.chatroom.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatRoom {

    private String chatRoomId;
    private String postId;
    private String joinerId;
    private LocalDateTime createdAt;

}
