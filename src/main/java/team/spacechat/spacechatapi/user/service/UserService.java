package team.spacechat.spacechatapi.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.spacechat.spacechatapi.user.dto.User;
import team.spacechat.spacechatapi.user.mapper.UserMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public User createUser(String name){
        User user = User.builder()
                .userId(UUID.randomUUID().toString())
                .name(name)
                .build();

        userMapper.createUser(user);

        return user;
    }

    public User updateUser(User user){

        userMapper.updateUser(user);

        return user;
    }
}
