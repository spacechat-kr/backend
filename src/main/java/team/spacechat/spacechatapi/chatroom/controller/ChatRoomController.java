package team.spacechat.spacechatapi.chatroom.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import team.spacechat.spacechatapi.chatroom.dto.ChatRoom;
import team.spacechat.spacechatapi.chatroom.service.ChatRoomService;
import team.spacechat.spacechatapi.common.ApiResponse;
import team.spacechat.spacechatapi.common.ResponseGenerator;

import java.util.List;

@RestController
@RequestMapping("/chatRoom")
@AllArgsConstructor
public class ChatRoomController {

    private ChatRoomService chatRoomService;

    @PostMapping("/create")
    @ApiOperation("채팅방 생성 : postId, joinerId(채팅 참가한 userId)")
    public ApiResponse createPost(@RequestBody ChatRoom chatRoom) throws Exception {
        ChatRoom result = chatRoomService.createChatRoom(chatRoom);
        return ResponseGenerator.ok(result);
    }

    @GetMapping("/list/{userId}")
    @ApiOperation("유저가 참가해있는 채팅방 목록 조회 : *")
    public ApiResponse getJoinedChatRoomList(@PathVariable("userId") String userId) {
        List<ChatRoom> result = chatRoomService.getJoinedChatRoomList(userId);
        return ResponseGenerator.ok(result);
    }

}
