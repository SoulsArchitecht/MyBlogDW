package sshibko.myblog.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshibko.myblog.api.response.AuthResponse;
import sshibko.myblog.service.UserService;

@Data
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final AuthResponse authResponse;

    public ApiAuthController(UserService userService, AuthResponse authResponse) {
        this.userService = userService;
        this.authResponse = authResponse;
    }

    //fix before security realisation
    @GetMapping("/check")
    public ResponseEntity<AuthResponse> authCheck() {
        return ResponseEntity.ok(authResponse);
    }

/*    @GetMapping("/check")
    public ResponseEntity<Boolean> authCheck() {
        return ResponseEntity.ok(userService.getApiAuthCheck());
    }*/


}
