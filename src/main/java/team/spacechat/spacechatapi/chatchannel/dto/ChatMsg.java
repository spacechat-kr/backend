package team.spacechat.spacechatapi.chatchannel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMsg {

    private String chatMsgId;
    private String chatRoomId;
    private String senderId;
    private String msgType;
    private String msgContent;
    private LocalDateTime createdAt;

}
