package id.hadiyan.tryspring3.controller;

import id.hadiyan.tryspring3.dto.LoginRequest;
import id.hadiyan.tryspring3.dto.LoginResponse;
import id.hadiyan.tryspring3.dto.RegisterRequest;
import id.hadiyan.tryspring3.dto.RegisterResponse;
import id.hadiyan.tryspring3.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
