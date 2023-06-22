package sshibko.myblog.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdvancedDTO {

    private String email;
    private boolean moderation;
    private int moderationCount;
    private boolean settings;

    public UserAdvancedDTO(int id, String photo, String email, boolean moderation, int moderationCount, boolean settings) {
        this.email = email;
        this.moderation = moderation;
        this.moderationCount = moderationCount;
        this.settings = settings;
    }
}
