package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "details_financed", schema = "public")
public class DetailsFinanced {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detfinanced")
    @SequenceGenerator(name = "seq_detfinanced", sequenceName = "seq_detfinanced", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "levels_financed_id", nullable = false)
    private Integer levelsFinancedId;

    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "VALUES", length = 10)
    private String values;

    @Column(name = "status", length = 1)
    private String status;


}
