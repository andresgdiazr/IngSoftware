package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;
    @Data
    @Entity
    @Table(name = "client", schema = "readOnlySchema")
    public class Client {
        @Id
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

        @Column(name = "status", length = 1)
        private String status;
    }

