package team.spacechat.spacechatapi.post.dto;

import lombok.Data;

@Data
public class PostSearch {

    String userId;
    double startLatitude;
    double endLatitude;
    double startLongitude;
    double endLongitude;

}
