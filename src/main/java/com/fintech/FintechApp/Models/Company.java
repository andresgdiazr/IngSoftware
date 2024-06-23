package com.fintech.FintechApp.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_seq")
    @SequenceGenerator(name = "company_id_seq", sequenceName = "company_id_seq", allocationSize = 1)
    private Integer id;
    private Integer companies_id;
    private Integer categorycomp_id;
    private Integer rif;
    private Integer location_Id;
    private String name;
    private Integer email;
    private String pass;
    private String phone;
    private String status;
}
