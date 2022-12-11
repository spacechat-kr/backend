package team.spacechat.spacechatapi.post.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.spacechat.spacechatapi.common.ApiResponse;
import team.spacechat.spacechatapi.common.ResponseGenerator;
import team.spacechat.spacechatapi.post.dto.Post;
import team.spacechat.spacechatapi.post.dto.PostSearch;
import team.spacechat.spacechatapi.post.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("/create")
    @ApiOperation("포스트 등록 : userId, title, description, latitude, longitude, iconPath")
    public ApiResponse createPost(@RequestBody Post post) throws Exception {
        postService.createPost(post);
        return ResponseGenerator.ok();
    }

    @PostMapping("/getPostByLocation")
    @ApiOperation("위/경도로 필터한 포스트 조회 : *")
    public ApiResponse getPostByLocation(@RequestBody PostSearch postSearch) throws Exception {
        List<Post> result = postService.getPostListByLocation(postSearch);
        return ResponseGenerator.ok(result);
    }

}
