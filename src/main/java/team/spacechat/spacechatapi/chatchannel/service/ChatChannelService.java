package team.spacechat.spacechatapi.chatchannel.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import team.spacechat.spacechatapi.chatchannel.dto.ChatSocketMsg;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ChatChannelService {
    private Map<String, List<WebSocketSession>> chatChannelMap;

    public void sendMsgToSameChatChannelSessions(ChatSocketMsg chatSocketMsg, WebSocketSession session) throws IOException {
        String roomId = chatSocketMsg.getRoomId();
        String sessionId = session.getId();

        if (chatChannelMap.get(roomId) == null){
            insertNewChatChannel(roomId, session);
        }

        if (!chatChannelMap.get(roomId).contains(session)){
            insertNewSession(roomId, session);
        }

        List<WebSocketSession> receiverSessionList =
                chatChannelMap.get(roomId).stream()
                                .filter(ws -> ws.getId() != sessionId)
                                        .collect(Collectors.toList());

        sendTextMessage(receiverSessionList, chatSocketMsg.getMessage());

    }

    private void insertNewChatChannel(String roomId, WebSocketSession session){
        List<WebSocketSession> newSessionList = new ArrayList<>();
        newSessionList.add(session);
        chatChannelMap.put(roomId, newSessionList);
    }

    private void insertNewSession(String roomId, WebSocketSession session){
        List<WebSocketSession> sessionList = chatChannelMap.get(roomId);
        sessionList.add(session);
    }


    private void sendTextMessage(List<WebSocketSession> sessionList, String message) throws IOException {
        TextMessage sendMsg = new TextMessage(message);
        for (WebSocketSession session : sessionList){
            session.sendMessage(sendMsg);
        }
    }

    private void sendTextMessage(WebSocketSession session, String message) throws IOException {
        TextMessage sendMsg = new TextMessage(message);
        session.sendMessage(sendMsg);
    }

}