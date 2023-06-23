package sshibko.myblog.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPostRequest {

    @JsonProperty("timestamp")
    private long timeStamp;
    private byte active;
    private String title;
    private String[] tags;
    private String text;
}
