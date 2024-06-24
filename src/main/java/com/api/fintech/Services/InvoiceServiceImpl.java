package com.api.fintech.Services;

import com.api.fintech.Models.Invoice;
import com.api.fintech.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    InvoiceRepository invoiceRepository;
    @Override
    public Invoice venta(Invoice venta ) {
        return invoiceRepository.save(venta);

    }
}
