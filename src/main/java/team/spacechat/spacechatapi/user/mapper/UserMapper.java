package team.spacechat.spacechatapi.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.spacechat.spacechatapi.user.dto.User;

@Mapper
public interface UserMapper {

    int createUser(User user);

    int updateUser(User user);

    User getUserByUserId(String userId);

}
