package team.spacechat.spacechatapi.mocktest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.spacechat.spacechatapi.common.ApiResponse;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/mockTest")
@RequiredArgsConstructor
public class MockTestController {

    private LocalDateTime lastUpdatedDt = LocalDateTime.now();

    @GetMapping("/lastUpdatedDt")
    public ApiResponse test(){
        return new ApiResponse("200", lastUpdatedDt.toString());
    }

}
