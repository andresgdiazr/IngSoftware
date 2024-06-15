package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category_comps", schema = "readOnlySchema")
public class CategoryComp {
    @Id
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
}
