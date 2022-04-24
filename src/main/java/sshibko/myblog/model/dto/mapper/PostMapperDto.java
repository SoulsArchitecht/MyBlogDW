package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.Post;



@Mapper
public interface PostMapperDto {
    PostMapperDto INSTANCE = Mappers.getMapper(PostMapperDto.class);

    PostMapperDto toPostDto(Post post);

    Post toPost(PostMapperDto postMapperDto);
}
