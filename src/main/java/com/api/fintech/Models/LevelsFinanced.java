package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "levels_financed", schema = "public")
public class LevelsFinanced {
    @Id
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 50)
    private String description;

    // Agrega los getters y setters
}
