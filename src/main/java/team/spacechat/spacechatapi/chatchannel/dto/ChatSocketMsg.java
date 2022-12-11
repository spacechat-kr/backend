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
    private String roomId;
    private String message;
}
