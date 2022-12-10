package team.spacechat.spacechatapi.chatchannel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSocketMsg {
    String roomId;
    String message;
}
