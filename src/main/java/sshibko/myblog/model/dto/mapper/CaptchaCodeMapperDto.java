package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.CaptchaCode;

@Mapper
public interface CaptchaCodeMapperDto {
    CaptchaCodeMapperDto INSTANCE = Mappers.getMapper(CaptchaCodeMapperDto.class);

/*    CaptchaCodeMapperDto toCaptchaCodeDto(CaptchaCode captchaCode);

    CaptchaCode toCaptchaCode(CaptchaCodeMapperDto captchaCodeMapperDto);*/
}
