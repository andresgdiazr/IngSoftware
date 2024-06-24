package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
    @Entity
    @Table(name = "client")
    public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
        @SequenceGenerator(name = "seq_client", sequenceName = "seq_client", allocationSize = 1)
        private Integer id;
        @Column(name = "location_id", nullable = false)
        private Integer locationId;

        @Column(name = "name", length = 20, nullable = false)
        private String name;

        @Column(name = "lastname", length = 30, nullable = false)
        private String lastName;

        @Column(name = "phone", length = 20)
        private String phone;

        @Column(name = "cedula", length = 10, unique = true, nullable = false)
        private String cedula; // Assuming cedula is a unique identifier

        @Column(name = "email", length = 2050)
        private String email;

        @Column(name = "pass", length = 100)
        private String password; // Assuming "pass" refers to the client's password

        @Column(name = "status", length = 10)
        private String status;
        Role role;


    }


