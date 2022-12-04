package team.spacechat.spacechatapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    int code;
    Object data;
}
