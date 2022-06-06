package sshibko.myblog.service;

import sshibko.myblog.api.response.PostListResponse;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.model.entity.Post;

public interface PostService {

    Post getPost(int id);

    PostListResponse getPostList(int offset, int limit, String mode);
}
