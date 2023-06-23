package sshibko.myblog.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {

    private String name;
    private String email;
    private String password;
    private int removePhoto;
}
