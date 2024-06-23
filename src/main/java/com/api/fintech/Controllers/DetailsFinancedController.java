package com.api.fintech.Controllers;

import com.api.fintech.Models.Client;
import com.api.fintech.Models.DetailsFinanced;
import com.api.fintech.Services.IClientService;
import com.api.fintech.Services.IDetallFinan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/detFinan")
@RestController
public class DetailsFinancedController {

    @Autowired
    IClientService clientService;
    @Autowired
    IDetallFinan detallFinanService;


    @GetMapping("/all")
    public List<DetailsFinanced> findAll(){

        return detallFinanService.mostrarDetalleFinan();
    }

    @PostMapping("/create")
    public ResponseEntity<Client> agregarCliente(@RequestBody Client cliente) throws Exception {
        clientService.crearCliente(cliente);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    @GetMapping("/financiamientoDet/{id}")
    public ResponseEntity<?> detalleFinamiento(@PathVariable Long id){
        return ResponseEntity.ok("detalles");
    }
}
