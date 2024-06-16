package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    @SequenceGenerator(name = "seq_company", sequenceName = "company_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "companies_id")
    private Integer companyId; // Assuming "companies_id" refers to a self-referential relationship

    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    @Column(name = "categorycomps_id", nullable = false)
    private Integer categoryCompsId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "rif", length = 10, unique = true, nullable = false)
    private String rif;

    @Column(name = "pass", length = 100)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "status", length = 1)
    private String status;

}
