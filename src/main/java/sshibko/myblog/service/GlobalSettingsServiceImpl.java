package sshibko.myblog.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.GlobalSettingsResponse;
import sshibko.myblog.model.enums.GlobalSettingsEnum;
import sshibko.myblog.repository.GlobalSettingsRepository;

import java.util.EnumMap;
import java.util.Map;

@Data
@Service
public class GlobalSettingsServiceImpl implements GlobalSettingsService {

    private GlobalSettingsRepository globalSettingsRepository;

    public GlobalSettingsResponse getGlobalSettingsResponse() {
        GlobalSettingsResponse globalSettingsResponse = new GlobalSettingsResponse();

        Map<GlobalSettingsEnum, Boolean> settingsMap = new EnumMap<>(GlobalSettingsEnum.class);
        globalSettingsRepository.findAll().forEach(set -> settingsMap.put(
                GlobalSettingsEnum.valueOf(set.getCode()),
                Boolean.parseBoolean(set.getValue())
        ));

        globalSettingsResponse.setMultiuserMode(
                settingsMap.get(GlobalSettingsEnum.MULTIUSER_MODE)
        );
        globalSettingsResponse.setPostPremoderation(
                settingsMap.get(GlobalSettingsEnum.POST_PREMODERATION)
        );
        globalSettingsResponse.setStatisticsIsPublic(
                settingsMap.get(GlobalSettingsEnum.STATISTICS_IS_PUBLIC)
        );
        return getGlobalSettingsResponse();
    }
}
