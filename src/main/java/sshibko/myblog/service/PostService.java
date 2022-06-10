package sshibko.myblog.service;

import sshibko.myblog.api.response.PostListResponse;
import sshibko.myblog.model.entity.Post;

import java.util.Optional;

public interface PostService {

    Optional<Post> getPost(int id);

    PostListResponse getPostList(int offset, int limit, String mode);
}
