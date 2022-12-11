package team.spacechat.spacechatapi.post.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Post {

    String postId;
    String userId;
    String title;
    String description;
    LocalDateTime createdAt;
    double latitude;
    double longitude;
    String iconPath;

}
