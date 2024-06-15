package com.api.fintech.Repositories;

import com.api.fintech.Models.DetailsInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsInvoiceRepository extends JpaRepository<DetailsInvoice, Long> {
}
