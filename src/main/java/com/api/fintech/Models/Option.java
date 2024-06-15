package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "options", schema = "public")
public class Option {
    @Id
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

}
