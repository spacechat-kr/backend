package team.spacechat.spacechatapi.post.mapper;

import org.apache.ibatis.annotations.Mapper;
import team.spacechat.spacechatapi.post.dto.Post;
import team.spacechat.spacechatapi.post.dto.PostSearch;

import java.util.List;

@Mapper
public interface PostMapper {

    int createPost(Post post);

    List<Post> getPostListByLocation(PostSearch postSearch);

    Post getPostByPostId(String postId);

}
