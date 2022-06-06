package sshibko.myblog.model.dto.mapper;

import sshibko.myblog.model.entity.Post;

public interface CalculatedPostDto {

    Post getPost();
    Integer getCommentCount();
    Integer getDislikeCount();
    Integer getLikeCount();
}
