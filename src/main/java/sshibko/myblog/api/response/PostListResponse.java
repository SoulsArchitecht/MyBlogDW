package sshibko.myblog.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sshibko.myblog.api.dto.PostDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListResponse {

    private int count;
    private List<PostDTO> posts;
}
