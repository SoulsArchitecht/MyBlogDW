package sshibko.myblog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.CaptchaCode;

@Repository
public interface CaptchaCodeRepository extends CrudRepository<CaptchaCode, Integer> {
}
