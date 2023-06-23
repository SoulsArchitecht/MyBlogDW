package sshibko.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByCode(String code);

    boolean isExistByIdAndEmailIgnoreCase(int id, String email);

    boolean isExistByEmailIgnoreCase(String email);
}
