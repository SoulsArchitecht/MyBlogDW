package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.PostComment;

@Mapper
public interface PostCommentMapperDto {
    PostCommentMapperDto INSTANCE = Mappers.getMapper(PostCommentMapperDto.class);

/*    PostCommentMapperDto toPostCommentDto(PostComment postComment);

    PostComment toPostComment(PostCommentMapperDto postCommentMapperDto);*/
}
