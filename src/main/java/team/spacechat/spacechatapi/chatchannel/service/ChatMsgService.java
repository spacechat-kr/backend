package team.spacechat.spacechatapi.chatchannel.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team.spacechat.spacechatapi.chatchannel.dto.ChatMsg;
import team.spacechat.spacechatapi.chatchannel.dto.ChatSocketMsg;
import team.spacechat.spacechatapi.chatchannel.mapper.ChatMsgMapper;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChatMsgService {

    private ChatMsgMapper chatMsgMapper;

    public void insertChatMsg(ChatSocketMsg chatSocketMsg) {
        chatMsgMapper.createChatMsg(chatSocketMsg.toChatMsg());
    }

    public List<ChatMsg> getChatMsgListByChatRoomId(String chatRoomId) {
        return chatMsgMapper.getChatMsgByChatRoomId(chatRoomId);
    }

}
