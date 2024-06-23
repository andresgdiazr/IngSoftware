package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category_comps")
public class CategoryComp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_catcomp")
    @SequenceGenerator(name = "seq_catcomp", sequenceName = "seq_catcomp", allocationSize = 1)

    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;


    
}
