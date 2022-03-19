package sshibko.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sshibko.myblog.api.response.GlobalSettingsResponse;
import sshibko.myblog.model.entity.GlobalSettings;

public interface GlobalSettingsRepository extends JpaRepository<GlobalSettings, Integer> {

    GlobalSettingsResponse findSettingResponseByCode(String code);
}
