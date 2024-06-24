package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "details_payfin", schema = "public")
public class DetailsPayfin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detpayfin")
    @SequenceGenerator(name = "seq_detpayfin", sequenceName = "seq_detpayfin", allocationSize = 1)

    @Column(name = "id")
    private Integer id;

    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;

    @Column(name = "quote")
    private Integer quote;

    @Column(name = "amt_payed", precision = 6, scale = 2)
    private BigDecimal amtPayed;

    @Column(name = "support_id", length = 12)
    private String supportId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "status", length = 1)
    private String status;


}
