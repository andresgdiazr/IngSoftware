package com.api.fintech.Jwt;

import com.api.fintech.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    String lastname;
    String username;
    String cedula;
    String password;
    Role role;

    Integer companyId; // Assuming "companies_id" refers to a self-referential relationship
    Integer locationId;
    Integer categoryCompsId;
    String rif;
    String email;
    String phone;
    String status;
}