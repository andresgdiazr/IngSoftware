package com.api.fintech.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataCompDTO {

     Integer companyId; // Assuming "companies_id" refers to a self-referential relationship
     Integer locationId;
     Integer categoryCompsId;
     String name;
     String rif;
     String email;
     String phone;
     String status;
     String token;


}


