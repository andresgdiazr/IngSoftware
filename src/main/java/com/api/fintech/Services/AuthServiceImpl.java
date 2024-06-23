package com.api.fintech.Services;

import com.api.fintech.Jwt.AuthResponse;
import com.api.fintech.Jwt.LoginRequest;
import com.api.fintech.Jwt.RegisterRequest;
import com.api.fintech.Models.Role;
import com.api.fintech.Models.User;
import com.api.fintech.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    UserRepository userRepository;
    private final JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findByName(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token).build();

    }

    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .lastName(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .cedula(request.getCedula())
                .role(Role.USER)
                .status("Activo")
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}