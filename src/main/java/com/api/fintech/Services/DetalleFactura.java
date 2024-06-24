package com.api.fintech.Services;

import com.api.fintech.Models.DetailsInvoice;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface DetalleFactura {

    void crearDetalle(DetailsInvoice detalle);
}
