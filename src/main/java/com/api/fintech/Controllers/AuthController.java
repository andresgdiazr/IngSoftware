package com.fintech.FintechApp.Controllers;

import com.fintech.FintechApp.Jwt.AuthResponse;
import com.fintech.FintechApp.Jwt.LoginRequest;
import com.fintech.FintechApp.Jwt.RegisterRequest;
import com.fintech.FintechApp.Models.User;
import com.fintech.FintechApp.Services.AuthService;
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
