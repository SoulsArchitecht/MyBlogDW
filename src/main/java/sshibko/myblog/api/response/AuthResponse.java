package sshibko.myblog.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthResponse {
    private boolean result = false;

    //user with fields: id, name, photo, email, moderation, moderationCount, settings

}
