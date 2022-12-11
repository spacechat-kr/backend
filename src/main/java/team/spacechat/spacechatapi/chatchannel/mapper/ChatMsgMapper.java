package team.spacechat.spacechatapi.chatchannel.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.spacechat.spacechatapi.chatchannel.dto.ChatMsg;

import java.util.List;

@Mapper
public interface ChatMsgMapper {

    int createChatMsg(ChatMsg chatMsg);

    List<ChatMsg> getChatMsgByChatRoomId(String chatRoomId);

}
