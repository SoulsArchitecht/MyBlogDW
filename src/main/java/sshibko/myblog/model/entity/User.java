package sshibko.myblog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString(callSuper = true, of = {"name"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "is_moderator", columnDefinition = "BOOLEAN", nullable = false)
    private Boolean isModerator;

    @Column(name = "reg_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime regTime;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "code")
    private String code;

    @Column(name = "photo", columnDefinition = "TEXT")
    private String photoUrl;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Post> postList;
    
}
