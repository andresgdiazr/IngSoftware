package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "options", schema = "public")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_options")
    @SequenceGenerator(name = "seq_options", sequenceName = "seq_options", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

}
