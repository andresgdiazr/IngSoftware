package com.api.fintech.DTO;

import com.api.fintech.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDtoLogin {
    String token;
    String lastname;
    String username;
    String cedula;
    String status;
    Role role;


}
