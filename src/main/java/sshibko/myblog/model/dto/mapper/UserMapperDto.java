package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.User;

@Mapper
public interface UserMapperDto {
    UserMapperDto INSTANCE = Mappers.getMapper(UserMapperDto.class);

/*    UserMapperDto toUserDto(User user);

    User toUser(UserMapperDto userMapperDto);*/
}
