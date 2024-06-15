package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Immutable // Optional: Mark as immutable if data shouldn't be modified
@Table(name = "view_invpayedfin") // Use the actual view name
public class ViewInvPayedFin {

    @Id // Since the view likely has a primary key based on `id`
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_inv")
    private String numberInv; // Use camelCase for consistency

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amt_financed")
    private Double amtFinanced; // Assuming financed amount is a double

    @Column(name = "payed")
    private Double payed;

    @Column(name = "outstanding_balance") // Replace "?column?" with a descriptive name
    private Double outstandingBalance; // Assuming the calculated value represents outstanding balance
}
