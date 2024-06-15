package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user", schema = "readOnlySchema") // Specify the existing table name
public class User {
    @Id
    private long id;
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "lastname", length = 30, nullable = false)
    private String lastName;

    @Column(name = "cedula", length = 10, unique = true, nullable = false)
    private String cedula;

    @Column(name = "pass", length = 100)
    private String password;

    @Column(name = "status", length = 1)
    private String status;
}