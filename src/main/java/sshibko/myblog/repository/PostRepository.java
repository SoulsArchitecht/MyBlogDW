package sshibko.myblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sshibko.myblog.model.dto.mapper.CalculatedPostDto;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.enums.ModerationStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    String queryById = "SELECT p FROM Post p WHERE p.id = :id";

    @Query(value = queryById)
    Post FindPostById(@Param("id") int id);

/*    @Query(
            "SELECT p "
                    + "FROM Post p "
                    + "LEFT JOIN User u ON u.id = p.user "
                    + "LEFT JOIN PostVote pv1 ON p.id = pv1.post AND pv1.value = true "
                    + "LEFT JOIN PostVote pv2 ON p.id = pv2.post AND pv2.value = false "
                    + "LEFT JOIN PostComment pc ON p.id = pc.posts "
                    + "LEFT JOIN Tag2Post t2p ON p.id = t2p.postId "
                    + "LEFT JOIN Tag t ON t.id = t2p.tagId "
                    + "WHERE p.id = :id "
                    + "GROUP BY p.id")
    Optional<Post> findPostById(@Param("id") int id);*/

    String query1 = "select count(p) as count "
            + "from Post p "
            + "where p.isActive = :isActive "
            + " and p.moderationStatus = :moderationStatus "
            + " and p.time <= :time ";

    @Query(value = query1)
    int getPostCount(
            @Param("isActive") boolean isActive,
            @Param("moderationStatus") ModerationStatus moderationStatus,
            @Param("time") LocalDateTime time);

    String query2 = "select p as post, "
            + " size(p.postComments) as commentCount, "
            + " coalesce((select size(v) from v where v.value > 0 group by p), 0) as likeCount,"
            + " coalesce((select size(v) from v where v.value < 0 group by p), 0) as dislikeCount "
            + "from Post p left join p.postVotes v "
            + "where p.isActive = :isActive "
            + " and p.moderationStatus = :moderationStatus "
            + " and p.time <= :time "
            + "group by p ";

    @Query(value = query2)
    List<CalculatedPostDto> getCalculatedPostDtoList(
            @Param("isActive") boolean isActive,
            @Param("moderationStatus") ModerationStatus moderationStatus,
            @Param("time") LocalDateTime time,
            Pageable pageable);

    @Query(value = queryById)
    Optional<Post> findPostById(int id);

    @Query(
            "SELECT p "
                    + "FROM Post p "
                    + "LEFT JOIN User u ON u.id = p.users "
                    + "LEFT JOIN PostVote pv1 ON p.id = pv1.posts AND pv1.value = 1 "
                    + "LEFT JOIN PostVote pv2 ON p.id = pv2.posts AND pv2.value = -1 "
                    + "LEFT JOIN PostComment pc ON p.id = pc.posts "
                    + "WHERE p.isActive = true AND p.moderationStatus = 'ACCEPTED' AND p.time <= CURRENT_TIME "
                    + "GROUP BY p.id")
    Page<Post> findAll(Pageable pageable);
}
