package sshibko.myblog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.PostComment;

@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Integer> {
}
