package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "details_invoice", schema = "public")
public class DetailsInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detinvoice")
    @Column(name = "id")
    private Integer id;

    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "qty", precision = 8, scale = 2)
    private BigDecimal qty;

    @Column(name = "amt_unit", precision = 8, scale = 2)
    private BigDecimal amtUnit;

    @Column(name = "status", length = 1)
    private String status;

}
