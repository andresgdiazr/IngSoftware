package com.fintech.FintechApp.Services;

import com.fintech.FintechApp.Jwt.AuthResponse;
import com.fintech.FintechApp.Jwt.LoginRequest;
import com.fintech.FintechApp.Jwt.RegisterRequest;
import com.fintech.FintechApp.Models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);


}
