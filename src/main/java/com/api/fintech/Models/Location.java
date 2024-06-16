package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "location", schema = "public")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_location")
    @SequenceGenerator(name = "seq_location", sequenceName = "seq_location", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "ancestor_id")
    private Integer ancestorId;

    @Column(name = "name", length = 100)
    private String name;
}
