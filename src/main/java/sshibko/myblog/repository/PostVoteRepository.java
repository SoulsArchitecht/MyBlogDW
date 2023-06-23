package sshibko.myblog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.entity.PostVote;
import sshibko.myblog.model.entity.User;

import java.util.Optional;

@Repository
public interface PostVoteRepository extends CrudRepository<PostVote, Integer> {

    Optional<Integer> countByValue(byte value);

    Optional<Integer> countByValueAndUser(byte value, User user);

    Optional<PostVote> findByUserAndPost(User user, Post post);
}
