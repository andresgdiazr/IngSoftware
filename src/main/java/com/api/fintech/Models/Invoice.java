package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "invoice", schema = "public")
public class Invoice {
    @Id
    private Long id;


    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "companies_id", nullable = false)
    private Integer companiesId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "number_inv", length = 12, nullable = false)
    private String numberInv;

    @Column(name = "amt_cash", precision = 6, scale = 2)
    private BigDecimal amtCash;

    @Column(name = "amt_financed", precision = 8, scale = 2)
    private BigDecimal amtFinanced;

    @Column(name = "amt_total", precision = 12, scale = 3)
    private BigDecimal amtTotal;

    @Column(name = "quotes_financed")
    private Integer quotesFinanced;

    @Column(name = "total_invoice", precision = 10, scale = 2)
    private BigDecimal totalInvoice;

    @Column(name = "status", length = 1)
    private String status;
}
