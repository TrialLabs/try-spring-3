package id.hadiyan.tryspring3.service;

import id.hadiyan.tryspring3.config.TokenUtil;
import id.hadiyan.tryspring3.dto.LoginRequest;
import id.hadiyan.tryspring3.dto.LoginResponse;
import id.hadiyan.tryspring3.dto.RegisterRequest;
import id.hadiyan.tryspring3.dto.RegisterResponse;
import id.hadiyan.tryspring3.entities.User;
import id.hadiyan.tryspring3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final TokenUtil tokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if(userRepository.findByUsername(registerRequest.username()).isPresent()){
            throw new FindException("Username already exist");
        }
        User user = User.builder()
                .username(registerRequest.username())
                .password(passwordEncoder.encode(registerRequest.password()))
                .build();
        userRepository.save(user);
        return new RegisterResponse(user.getId(), user.getUsername());
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenUtil.generateToken(authentication);
        return new LoginResponse(token);
    }
}
