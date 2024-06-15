package com.api.fintech.Repositories;

import com.api.fintech.Models.ViewCliInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewCliInvoiceRepository extends JpaRepository<ViewCliInvoice, Integer> {
}
