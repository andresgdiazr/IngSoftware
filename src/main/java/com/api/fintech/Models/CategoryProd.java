package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category_prods", schema = "public")
public class CategoryProd {
    @Id
    private Integer id;

    @Column(name = "companies_id", nullable = false)
    private Integer companiesId;

    @Column(name = "ancestor_id")
    private Integer ancestorId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;


}
