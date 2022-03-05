package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class DefaultController {

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
}
