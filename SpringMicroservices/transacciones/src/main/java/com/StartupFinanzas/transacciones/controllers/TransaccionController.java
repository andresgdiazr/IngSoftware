package com.StartupFinanzas.transacciones.controllers;

import com.StartupFinanzas.transacciones.entities.Transaccion;
import com.StartupFinanzas.transacciones.repositories.TransaccionReposiotorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/transacctions")
@RestController
public class TransaccionController {
    @Autowired
    TransaccionReposiotorio transaccionRepositorio;

    @GetMapping()
    public List<Transaccion> findAll(){

        return transaccionRepositorio.findAll();
    }
    @GetMapping("/cliente/transaccion")
    public List<Transaccion> get(@RequestParam String cuenta){

        return transaccionRepositorio.findByCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestParam long id, @RequestBody Transaccion input){
        Optional<Transaccion> transanccion = transaccionRepositorio.findById(id);
        if(transanccion.isPresent()){
            Transaccion transac = transanccion.get();
            transac.setCargo(input.getCargo());
            transac.setCanal(input.getCanal());
            transac.setCuenta(input.getCuenta());
            transac.setMonto(input.getMonto());
            return  new ResponseEntity<>(transac, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

        @PostMapping()
        public ResponseEntity<?>save(@RequestBody Transaccion input){

        Transaccion transac = transaccionRepositorio.save(input);
        return ResponseEntity.ok(transac);

        }



}
