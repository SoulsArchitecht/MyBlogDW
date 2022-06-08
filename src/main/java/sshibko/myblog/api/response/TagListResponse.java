package sshibko.myblog.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagListResponse {

    @JsonProperty("tags")
    private List<TagResponse> tagResponseList;
}
