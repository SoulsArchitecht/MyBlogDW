package sshibko.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sshibko.myblog.model.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllById(int id);
}
