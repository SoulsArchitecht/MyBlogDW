package sshibko.myblog.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.GlobalSettingsResponse;
import sshibko.myblog.model.entity.GlobalSettings;
import sshibko.myblog.model.enums.GlobalSettingsEnum;
import sshibko.myblog.repository.GlobalSettingsRepository;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Data
@Service
public class GlobalSettingsServiceImpl implements GlobalSettingsService {

    private GlobalSettingsRepository globalSettingsRepository;

    public GlobalSettingsServiceImpl(GlobalSettingsRepository globalSettingsRepository) {
        this.globalSettingsRepository = globalSettingsRepository;
    }

    /*    public GlobalSettingsResponse getGlobalSettingsResponse() {
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
    }*/

    public GlobalSettingsResponse getGlobalSettingsResponse() {

        GlobalSettingsResponse settingsResponse = new GlobalSettingsResponse();

        List<GlobalSettings> allSettings = globalSettingsRepository.findAll();

        allSettings.forEach(s -> {
            if ((s.getCode().equals("MULTIUSER_MODE")) && (s.getValue().equals("YES"))) {
                settingsResponse.setMultiuserMode(true);
            }
        });

        allSettings.forEach(s -> {
            if ((s.getCode().equals("POST_PREMODERATION")) && (s.getValue().equals("YES"))) {
                settingsResponse.setPostPremoderation(true);
            }
        });

        allSettings.forEach(s -> {
            if ((s.getCode().equals("STATISTICS_IS_PUBLIC")) && (s.getValue().equals("YES"))) {
                settingsResponse.setStatisticsIsPublic(true);
            }
        });

        return settingsResponse;
    }
}
