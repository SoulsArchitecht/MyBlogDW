package sshibko.myblog.api.response;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class InitResponse {
    @Value("${blog.details.title}")
    private String title;
    @Value("${blog.details.subtitle}")
    private String subtitle;
    @Value("${blog.details.phone}")
    private String phone;
    @Value("${blog.details.email}")
    private String email;
    @Value("${blog.details.copyright}")
    private String copyright;
    @Value("${blog.details.copyrightFrom}")
    private String copyrightFrom;
}
