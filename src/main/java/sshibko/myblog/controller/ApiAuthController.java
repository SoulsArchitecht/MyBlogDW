package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshibko.myblog.service.UserService;

@Data
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final UserService userService;

    @GetMapping("/check")
    public ResponseEntity<Boolean> authCheck() {
        return ResponseEntity.ok(userService.getApiAuthCheck());
    }
}
