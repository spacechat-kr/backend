package team.spacechat.spacechatapi.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.spacechat.spacechatapi.user.dto.User;
import team.spacechat.spacechatapi.user.mapper.UserMapper;

@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public boolean createUser(User user) throws Exception {

        User newUser = User.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .build();

        int result = userMapper.createUser(newUser);

        if (result == 1){
            return true;
        } else{
            throw new Exception();
        }

    }

    public User updateUser(User user){

        userMapper.updateUser(user);

        return user;
    }

    public User getUserByUserId(String userId){

        User user = userMapper.getUserByUserId(userId);

        return user;
    }
}
