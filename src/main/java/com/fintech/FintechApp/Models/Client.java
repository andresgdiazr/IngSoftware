package com.fintech.FintechApp.Models;

import jakarta.persistence.*;
import lombok.Data;
    @Data
    @Entity
    public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
        @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
        private Integer id;
        private int location_Id;
        private String name;
        @Column(name = "lastname")
        private String lastName;
        private String email;
        private String phone;
        private String cedula;
        private String pass;
        private String status;
    }

