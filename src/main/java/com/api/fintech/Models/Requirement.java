package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "requirements", schema = "public")
public class Requirement {
    @Id
    private Integer id;

    @Column(name = "ancestor_id")
    private Integer ancestorId;

    @Column(name = "name", length = 30)
    private String name;

}
