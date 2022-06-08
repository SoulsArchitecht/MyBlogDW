package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.Tag;

@Mapper
public interface TagMapperDto {
    TagMapperDto INSTANCE = Mappers.getMapper(TagMapperDto.class);

    TagMapperDto toTagDto(Tag tag);

    Tag toTag(TagMapperDto tagMapperDto);
}
