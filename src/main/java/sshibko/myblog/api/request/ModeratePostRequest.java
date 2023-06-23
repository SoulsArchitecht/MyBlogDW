package sshibko.myblog.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeratePostRequest {

    @JsonProperty("post_id")
    private int postId;
    private String decision;
}