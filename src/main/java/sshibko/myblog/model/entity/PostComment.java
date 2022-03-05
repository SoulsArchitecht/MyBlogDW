package sshibko.myblog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_comments")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private PostComment postComment;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false, referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "time", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime time;

    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

}
