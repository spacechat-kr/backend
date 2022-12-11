package team.spacechat.spacechatapi.chatchannel.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.spacechat.spacechatapi.chatchannel.dto.ChatMsg;
import team.spacechat.spacechatapi.chatchannel.service.ChatMsgService;
import team.spacechat.spacechatapi.common.ApiResponse;
import team.spacechat.spacechatapi.common.ResponseGenerator;

import java.util.List;

@RestController
@RequestMapping("/chatMsg")
@AllArgsConstructor
public class ChatMsgController {

    private ChatMsgService chatMsgService;

    @GetMapping("/list/{chatRoomId}")
    @ApiOperation("채팅방 id로 채팅 내역을 모두 조회 : *")
    public ApiResponse getChatMsgList(@PathVariable("chatRoomId") String chatRoomId) {
        List<ChatMsg> result = chatMsgService.getChatMsgListByChatRoomId(chatRoomId);
        return ResponseGenerator.ok(result);
    }

}
