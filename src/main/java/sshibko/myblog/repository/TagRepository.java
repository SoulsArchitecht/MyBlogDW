package sshibko.myblog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.Tag;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

    Optional<Tag> findByName(String name);
}
