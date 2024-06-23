package com.fintech.FintechApp.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoryComp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_comp_id_seq")
    @SequenceGenerator(name = "category_comp_id_seq", sequenceName = "category_comp_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
}
