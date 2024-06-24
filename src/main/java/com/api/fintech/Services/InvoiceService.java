package com.api.fintech.Services;

import com.api.fintech.Models.Invoice;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {
    Invoice venta(Invoice venta);
}
