package com.api.fintech.Controllers;

import com.api.fintech.Models.DetailsInvoice;
import com.api.fintech.Models.Invoice;
import com.api.fintech.Models.Product;
import com.api.fintech.Services.IProductService;
import com.api.fintech.Services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;

@RestController
@RequestMapping("/ventas")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired
    IProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    public ResponseEntity<Invoice>venta(@RequestBody Invoice venta
            , @RequestParam(name = "item_id", required = false)Long itemId,
              @RequestParam(name = "cant") int cantidad){

            Invoice ventaNueva = invoiceService.venta(venta);

            Product producto = productService.findProductById(itemId);
            DetailsInvoice linea = new DetailsInvoice();
            linea.setQty(BigDecimal.valueOf((cantidad)));
            linea.setProductId(producto.getId());
            linea.setInvoiceId(Math.toIntExact(ventaNueva.getId()));

            log.info("ID: " + itemId + " cantidad: " + cantidad);

        return new ResponseEntity<>(venta,HttpStatus.OK);
    }
}
