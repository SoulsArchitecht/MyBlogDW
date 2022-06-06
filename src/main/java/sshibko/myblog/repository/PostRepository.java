package sshibko.myblog.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sshibko.myblog.model.dto.mapper.CalculatedPostDto;
import sshibko.myblog.model.entity.Post;
import sshibko.myblog.model.enums.ModerationStatus;

import java.time.LocalDateTime;
import java.util.List;

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

    String query2 = "select p as post, "
            + " size(p.post(Comments) as commentCount, "
            + " coalesce((select size(v) fom v where v.value > 0 group by p), 0) as likeCount,"
            + " coalesce((select size(v) from v where v.value < 0 group by p), 0) as dislikeCount "
            + "from Post p left join p.postVotes v "
            + "where p.isActive = :isActive "
            + " and p.moderationStatus = :moderationStatus "
            + " and p.time <= :time "
            + "group by p ";

    @Query(value = query2, nativeQuery = true)
    List<CalculatedPostDto> getCalculatedPostDtoList(
            @Param("isActive") boolean isActive,
            @Param("moderationStatus") ModerationStatus moderationStatus,
            @Param("time") LocalDateTime time,
            Pageable pageable);

}
