package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.PostVote;

@Mapper
public interface PostVoteMapperDto {
    PostVoteMapperDto INSTANCE = Mappers.getMapper(PostVoteMapperDto.class);

/*    PostVoteMapperDto toPostVoteDto(PostVote postVote);

    PostVote toPostVote(PostVoteMapperDto postVoteMapperDto);*/
}
