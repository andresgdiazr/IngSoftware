package com.api.fintech.Controllers;

import com.api.fintech.Models.DetailsPayfin;
import com.api.fintech.Services.IDetailsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/pagos")
public class DetailsPayFinController {

    @Autowired
    IDetailsPayService payService;

    @PostMapping
    public ResponseEntity<?> pagos(@RequestBody DetailsPayfin pago){
        LocalDateTime hoy = LocalDateTime.now();
        DetailsPayfin nuevoPAgo = DetailsPayfin.builder()
                .quote(pago.getQuote())
                .createdAt(Timestamp.valueOf(hoy))
                .invoiceId(pago.getInvoiceId())
                .build();
        payService.pagar(pago);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
