package sshibko.myblog.service;

import org.springframework.stereotype.Service;
import sshibko.myblog.api.response.SettingsResponse;

@Service
public class SettingsService {

    public SettingsResponse getGlobalSettings() {
        SettingsResponse settingsResponse = new SettingsResponse();
        settingsResponse.setMultiuserMode(true);
        settingsResponse.setStatisticsIsPublic(true);
        return settingsResponse;
    }
}
