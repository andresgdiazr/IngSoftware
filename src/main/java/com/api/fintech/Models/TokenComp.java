package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "token_comp", schema = "public")
public class TokenComp {
    @Id
    private Integer id;

    @Column(name = "companies_id", nullable = false)
    private Integer companiesId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "value", length = 20)
    private String value;

    @Column(name = "status", length = 1)
    private String status;

}