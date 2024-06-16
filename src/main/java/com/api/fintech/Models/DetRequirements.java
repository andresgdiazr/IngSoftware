package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "det_requirements", schema = "public")
public class DetRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detrequirement")
    @SequenceGenerator(name = "seq_detrequirement", sequenceName = "seq_detrequirement", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "levelsfinanced_id", nullable = false)
    private Integer levelsFinancedId;

    @Column(name = "requirements_id", nullable = false)
    private Integer requirementsId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "VALUES", length = 50)
    private String values;

    @Column(name = "status", length = 1)
    private String status;

    // Agrega las relaciones con otras entidades si es necesario

    // Agrega los getters y setters
}
