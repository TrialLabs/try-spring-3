package id.hadiyan.tryspring3.service;

import id.hadiyan.tryspring3.dto.LoginRequest;
import id.hadiyan.tryspring3.dto.LoginResponse;
import id.hadiyan.tryspring3.dto.RegisterRequest;
import id.hadiyan.tryspring3.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
