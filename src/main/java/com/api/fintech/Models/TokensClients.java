package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "tokens_clients", schema = "public")
public class TokensClients {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tokencli")
    @Column(name = "id")
    private Integer id;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "value", length = 20)
    private String value;

    @Column(name = "status", length = 1)
    private String status;

}