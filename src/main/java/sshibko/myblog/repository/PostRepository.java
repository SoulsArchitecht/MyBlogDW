package sshibko.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.enums.ModerationStatus;

import java.time.LocalDateTime;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post getPostById(int id);

    String query1 = "select count(p) as count "
            + "from Post p "
            + "where p.isActive = :isActive "
            + " and p.moderationStatus = :moderationStatus "
            + " and p.time <= :time ";

    @Query(value = query1, nativeQuery = true)
    int getPostCount(
            @Param("isActive") boolean isActive,
            @Param("moderationStatus") ModerationStatus moderationStatus,
            @Param("time") LocalDateTime time);

}
