package team.spacechat.spacechatapi.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.spacechat.spacechatapi.user.dto.User;

@Mapper
public interface UserMapper {

    public void createUser(User user);

    public void updateUser(User user);

}
