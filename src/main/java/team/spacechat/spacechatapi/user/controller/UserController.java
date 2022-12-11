package team.spacechat.spacechatapi.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ApiResponse createUser(User user){
        User result = userService.createUser(user.getName());
        return ResponseGenerator.ok(result);
    }

    @PostMapping("/update")
    public ApiResponse updateUser(User user){
        User result = userService.updateUser(user);
        return ResponseGenerator.ok(result);
    }

}
