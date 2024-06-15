package com.api.fintech.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Immutable // Optional: Mark as immutable if data shouldn't be modified
@Table(name = "view_cliinvoice") // Use the actual view name
public class ViewCliInvoice {

    @Id // Since the view likely has a primary key based on `id`
    @Column(name = "id")
    private Integer id;

    @Column(name = "number_inv")
    private String numberInv; // Use camelCase for consistency

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "amt_total")
    private Double amtTotal; // Assuming total amount is a double

    @Column(name = "quotes_financed")
    private Double quotesFinanced; // Assuming financed quotes is a double

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "name_company")
    private String nameCompany;
}
