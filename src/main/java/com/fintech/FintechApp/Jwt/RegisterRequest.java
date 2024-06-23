package com.fintech.FintechApp.Jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {

     String lastname;
     String username;
     String cedula;
     String password;

}
