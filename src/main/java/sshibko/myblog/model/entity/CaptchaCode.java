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
@Table(name = "captcha_codes")
public class CaptchaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime time;

    @Column(name = "code", columnDefinition = "BOOLEAN", nullable = false)
    private String code;

    @Column(name = "secret_code", columnDefinition = "BOOLEAN", nullable = false)
    private String secretCode;
}
