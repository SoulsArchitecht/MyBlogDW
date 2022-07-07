package sshibko.myblog.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListResponse {
    private int count;
    @JsonProperty("posts")
    private List<PostResponse> postResponseList;
}
