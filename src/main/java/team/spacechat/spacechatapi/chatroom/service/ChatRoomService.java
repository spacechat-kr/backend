package team.spacechat.spacechatapi.chatroom.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.spacechat.spacechatapi.chatroom.dto.ChatRoom;
import team.spacechat.spacechatapi.chatroom.mapper.ChatRoomMapper;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ChatRoomService {

    private ChatRoomMapper chatRoomMapper;

    public ChatRoom createChatRoom(ChatRoom chatRoom) throws Exception {

        ChatRoom existChatRoom = getExistChatRoom(chatRoom.getPostId(), chatRoom.getJoinerId());
        if (existChatRoom != null) {
            return existChatRoom;
        }

        String newChatRoomId = UUID.randomUUID().toString();

        ChatRoom newChatRoom = ChatRoom.builder()
                .chatRoomId(newChatRoomId)
                .postId(chatRoom.getPostId())
                .joinerId(chatRoom.getJoinerId())
                .build();

        int result = chatRoomMapper.createChatRoom(newChatRoom);

        if (result == 1) {
            return chatRoomMapper.getChatRoomById(newChatRoomId);
        } else {
            throw new Exception();
        }
    }

    public ChatRoom getExistChatRoom(String postId, String joinerId) {
        HashMap params = new HashMap();
        params.put("postId", postId);
        params.put("joinerId", joinerId);

        return chatRoomMapper.getChatRoomByPostIdAndJoinerId(params);
    }

    public List<ChatRoom> getJoinedChatRoomList(String userId) {
        return chatRoomMapper.getChatRoomListByUserId(userId);
    }

}
