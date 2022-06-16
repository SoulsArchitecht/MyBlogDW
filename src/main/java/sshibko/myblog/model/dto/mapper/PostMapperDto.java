package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.api.response.PostResponse;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.dto.mapper.CalculatedPostDto;


@Mapper
public interface PostMapperDto {
    PostMapperDto INSTANCE = Mappers.getMapper(PostMapperDto.class);

    //PostMapperDto toPostDto(Post post);

    //Post toPost(PostMapperDto postMapperDto);

    @Mapping(source = "calculatedPostDto.post.id", target = "id")
    @Mapping(source = "calculatedPostDto.post.user", target = "user")
    @Mapping(source = "calculatedPostDto.post.title", target = "title")
    @Mapping(source = "calculatedPostDto.post.viewCount", target = "viewCount")
    @Mapping(target = "announce", expression = "java(Announce.getAnnounce(calculatedPostDto))")
    @Mapping(target = "timestamp", expression = "java(Announce.getTimestamp(calculatedPostDto))")
    PostResponse calculatedPostDtoToPostDto(CalculatedPostDto calculatedPostDto);
}
