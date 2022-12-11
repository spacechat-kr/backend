package team.spacechat.spacechatapi.post.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Post {

    private String postId;
    private String userId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private double latitude;
    private double longitude;
    private String iconPath;

}
