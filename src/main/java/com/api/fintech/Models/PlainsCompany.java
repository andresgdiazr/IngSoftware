package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "plains_company", schema = "public")
public class PlainsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plaincompany")
    @SequenceGenerator(name = "seq_plaincompany", sequenceName = "seq_plaincompany", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "plains_id", nullable = false)
    private Integer plainsId;

    @Column(name = "companies_id", nullable = false)
    private Integer companiesId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "status", length = 1)
    private String status;

}
