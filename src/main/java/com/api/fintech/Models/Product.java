package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    private Integer id;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "codebar", length = 20)
    private String codebar;

    @Column(name = "status", length = 1)
    private String status;


}
