package team.spacechat.spacechatapi.chatchannel.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import team.spacechat.spacechatapi.chatchannel.dto.ChatSocketMsg;
import team.spacechat.spacechatapi.chatchannel.service.ChatChannelService;

@Slf4j
@Component
@AllArgsConstructor
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private ChatChannelService chatChannelService;
    private ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receiveMsg = message.getPayload();

        ChatSocketMsg chatSocketMsg = objectMapper.readValue(receiveMsg, ChatSocketMsg.class);

        log.info("session: {}, receiveMsg: {}", session.getId(), receiveMsg);

        chatChannelService.sendMsgToSameChatChannelSessions(chatSocketMsg, session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Session {} closed with status {}", session, status);

        chatChannelService.deleteSession(session);
    }


}
