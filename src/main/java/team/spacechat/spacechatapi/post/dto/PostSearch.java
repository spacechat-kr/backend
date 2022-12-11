package team.spacechat.spacechatapi.post.dto;

import lombok.Data;

@Data
public class PostSearch {

    private String userId;
    private double startLatitude;
    private double endLatitude;
    private double startLongitude;
    private double endLongitude;

}
