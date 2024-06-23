package com.api.fintech.Controllers;

import com.api.fintech.Jwt.AuthResponse;
import com.api.fintech.Jwt.LoginRequest;
import com.api.fintech.Jwt.RegisterRequest;
import com.api.fintech.Models.User;
import com.api.fintech.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping( "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse user =authService.login(request);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping( "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
           AuthResponse user= authService.register(request);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
