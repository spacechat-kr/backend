package team.spacechat.spacechatapi.user.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import team.spacechat.spacechatapi.common.ApiResponse;
import team.spacechat.spacechatapi.common.ResponseGenerator;
import team.spacechat.spacechatapi.user.dto.User;
import team.spacechat.spacechatapi.user.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    @ApiOperation("유저 신규 등록 : *")
    public ApiResponse createUser(@RequestBody User user) throws Exception {
        userService.createUser(user);
        return ResponseGenerator.ok();
    }

    @PostMapping("/update")
    @ApiOperation("유저 정보 수정 : *")
    public ApiResponse updateUser(@RequestBody User user){
        User result = userService.updateUser(user);
        return ResponseGenerator.ok(result);
    }

    @GetMapping
    @ApiOperation("유저 아이디로 유저 정보 조회 : *")
    public ApiResponse getUserByUserId(String userId){
        User result = userService.getUserByUserId(userId);
        return ResponseGenerator.ok(result);
    }


}
