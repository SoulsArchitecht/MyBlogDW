package sshibko.myblog.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPostDTO {

    private int id;
    @JsonProperty("timestamp")
    private long timeStamp;
    private String text;
    private UserDTO user;
}
