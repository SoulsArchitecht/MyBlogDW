package sshibko.myblog.model.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.Post;



@Mapper
public interface PostMapperDto {
    PostMapperDto INSTANCE = Mappers.getMapper(PostMapperDto.class);

    @Mapping(source = "something", target = "something")
    PostMapperDto toPostDto(Post post);

    @InheritInverseConfiguration
    Post toPost(PostMapperDto postMapperDto);


}
