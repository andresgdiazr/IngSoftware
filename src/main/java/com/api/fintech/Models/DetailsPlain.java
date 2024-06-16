package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "details_plain", schema = "public")
public class DetailsPlain {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detplain")
    @SequenceGenerator(name = "seq_detplain", sequenceName = "seq_detplain", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "plains_id", nullable = false)
    private Integer plainsId;

    @Column(name = "options_id", nullable = false)
    private Integer optionsId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "VALUES", length = 50)
    private String values;

    @Column(name = "status", length = 1)
    private String status;

}
