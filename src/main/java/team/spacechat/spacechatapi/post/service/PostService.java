package team.spacechat.spacechatapi.post.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.spacechat.spacechatapi.post.dto.Post;
import team.spacechat.spacechatapi.post.dto.PostSearch;
import team.spacechat.spacechatapi.post.mapper.PostMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PostService {

    private PostMapper postMapper;

    public boolean createPost(Post post) throws Exception {

        Post newPost = Post.builder()
                .postId(UUID.randomUUID().toString())
                .userId(post.getUserId())
                .title(post.getTitle())
                .description(post.getDescription())
                .latitude(post.getLatitude())
                .longitude(post.getLongitude())
                .iconPath(post.getIconPath())
                .build();

        int result = postMapper.createPost(newPost);

        if (result == 1){
            return true;
        } else{
            throw new Exception();
        }
    }

    public List<Post> getPostListByLocation(PostSearch postSearch){
        List<Post> postList = postMapper.getPostListByLocation(postSearch);
        return postList;
    }
}
