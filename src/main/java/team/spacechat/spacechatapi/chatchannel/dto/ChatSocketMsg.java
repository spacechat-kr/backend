package team.spacechat.spacechatapi.chatchannel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 소켓 송수신 시 사용되는 메시지 포맷
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSocketMsg {

    private String chatRoomId;
    private String senderId;
    private String msgType;
    private String msgContent;

    public ChatMsg toChatMsg() {
        return ChatMsg.builder()
                .chatRoomId(this.chatRoomId)
                .senderId(this.senderId)
                .msgContent(this.msgContent)
                .msgType(this.msgType)
                .build();
    }

}
