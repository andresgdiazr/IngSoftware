package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

@Data
@Entity
@Immutable // Optional: Mark as immutable if data shouldn't be modified
@Table(name = "view_invdetails") // Use the actual view name
public class ViewInvDetails {

    @Id // Since the view likely has a primary key based on `id`
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    private String name;

    @Column(name = "qty")
    private Integer qty;
}
