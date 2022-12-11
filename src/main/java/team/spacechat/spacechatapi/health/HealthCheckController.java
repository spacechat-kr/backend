package team.spacechat.spacechatapi.health;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.spacechat.spacechatapi.common.ApiResponse;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class HealthCheckController {

    private LocalDateTime lastUpdatedDt = LocalDateTime.now();

    @GetMapping("/health")
    public ApiResponse test(){
        return new ApiResponse("200", lastUpdatedDt.toString());
    }

}
