package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "companies", schema = "readOnlySchema")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
//    @SequenceGenerator(name = "company_id_seq", sequenceName = "company_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "companies_id")
    private Integer companyId; // Assuming "companies_id" refers to a self-referential relationship

    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    @Column(name = "categorycomps_id", nullable = false)
    private Integer categoryCompsId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "rif", length = 10, unique = true, nullable = false)
    private String rif; // Assuming "rif" is a unique identifier

    @Column(name = "pass", length = 100)
    private String password; // Assuming "pass" refers to the company's password

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "status", length = 1)
    private String status;

//    // ManyToOne relationships
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "location_id")
//    private Location location;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categorycomps_id")
//    private CategoryComp categoryComp;

    // Optional: ManyToMany relationship (assuming a separate table exists)
    // @ManyToMany
    // @JoinTable(name = "company_clients",
    //            joinColumns = @JoinColumn(name = "company_id"),
    //            inverseJoinColumns = @JoinColumn(name = "client_id"))
    // private List<Client> clients;

    // Getters and Setters (optional but recommended)
    // ... (similar to the Client class)

}
