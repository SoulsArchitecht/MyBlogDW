package sshibko.myblog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.GlobalSettings;
@Repository
public interface GlobalSettingsRepository extends CrudRepository<GlobalSettings, Integer> {

    GlobalSettings findByCode(String code);

    boolean IsExistByCodeAndValueIgnoreCase(String code, String value);
}
