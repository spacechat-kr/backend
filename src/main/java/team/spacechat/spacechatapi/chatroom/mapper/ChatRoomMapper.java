package team.spacechat.spacechatapi.chatroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.spacechat.spacechatapi.chatroom.dto.ChatRoom;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ChatRoomMapper {

    int createChatRoom(ChatRoom chatRoom);

    ChatRoom getChatRoomById(String chatRoomId);

    ChatRoom getChatRoomByPostIdAndJoinerId(HashMap map);

    List<ChatRoom> getChatRoomListByUserId(String userId);

}
