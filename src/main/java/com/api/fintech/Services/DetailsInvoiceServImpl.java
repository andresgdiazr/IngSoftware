package com.api.fintech.Services;

import com.api.fintech.Models.DetailsInvoice;
import com.api.fintech.Repositories.DetailsInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsInvoiceServImpl implements DetalleFactura{
    @Autowired
    DetailsInvoiceRepository invoiceRepository;
    @Override
    public void crearDetalle(DetailsInvoice detalle) {
        invoiceRepository.save(detalle);
    }
}
