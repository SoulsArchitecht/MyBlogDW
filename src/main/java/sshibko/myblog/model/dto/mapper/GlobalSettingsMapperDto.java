package sshibko.myblog.model.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sshibko.myblog.model.entity.GlobalSettings;

@Mapper
public interface GlobalSettingsMapperDto {
    GlobalSettingsMapperDto INSTANCE = Mappers.getMapper(GlobalSettingsMapperDto.class);

/*    GlobalSettingsMapperDto toGlobalSettingsDto(GlobalSettings globalSettings);

    GlobalSettings toGlobalSettings(GlobalSettingsMapperDto globalSettingsMapperDto);*/
}
