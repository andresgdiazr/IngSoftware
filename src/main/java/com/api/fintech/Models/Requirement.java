package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "requirements", schema = "public")
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_requirements")
    @Column(name = "id")
    private Integer id;

    @Column(name = "ancestor_id")
    private Integer ancestorId;

    @Column(name = "name", length = 30)
    private String name;

}
