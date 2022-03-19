package sshibko.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sshibko.myblog.model.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag getTagById(int id);
}
