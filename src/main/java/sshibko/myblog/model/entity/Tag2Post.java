package sshibko.myblog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag2post")
public class Tag2Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "post_id", nullable = false )
    private int postId;

    @Column(name = "tag_id", nullable = false)
    private int tagId;
}
