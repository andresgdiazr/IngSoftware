package com.api.fintech.Controllers;

import com.api.fintech.Models.DetailsInvoice;
import com.api.fintech.Models.Invoice;
import com.api.fintech.Models.Product;
import com.api.fintech.Services.DetalleFactura;

import com.api.fintech.Services.IProductService;
import com.api.fintech.Services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    IProductService productService;

    @Autowired
    DetalleFactura detailsInvoiceService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    public ResponseEntity<Invoice>venta(@RequestBody Invoice venta
            , @RequestParam(name = "item_id", required = false)Long itemId,
              @RequestParam(name = "cant") int cantidad) throws Exception {

            Invoice ventaNueva = invoiceService.venta(venta);

            Optional<Product> producto = productService.findProductById(itemId);
            if(producto.isPresent()){
                DetailsInvoice linea = new DetailsInvoice();
                linea.setQty(BigDecimal.valueOf((cantidad)));
                linea.setProductId(producto.get().getId());
                linea.setInvoiceId(Math.toIntExact(ventaNueva.getId()));

            detailsInvoiceService.crearDetalle(linea);
                log.info("ID: " + itemId + " cantidad: " + cantidad + "Se guardo correctamente el detalle");
            }else{
                throw new Exception("producto no encontrado");
            }

        return new ResponseEntity<>(venta,HttpStatus.OK);
    }
}
