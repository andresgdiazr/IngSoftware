package com.StartupFinanzas.producto.controllers;


import com.StartupFinanzas.producto.entities.Producto;
import com.StartupFinanzas.producto.repositories.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductoController {
    @Autowired
    ProductoRepositorio productoRepositorio;

    @GetMapping()
    public List<Producto> findAll(){

        return productoRepositorio.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id){
        Optional<Producto> producto = productoRepositorio.findById(id);
        if(producto.isPresent()){
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Producto input){
        Optional<Producto> producto = productoRepositorio.findById(id);
        if(producto.isPresent()){
            Producto cliente1 = producto.get();
            cliente1.setNombre(input.getNombre());
            cliente1.setDescripcion(input.getDescripcion());
            cliente1.setCodigo(input.getCodigo());

            Producto salvar = productoRepositorio.save(cliente1);
            return  new ResponseEntity<>(salvar,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Producto input){
        Producto cliente = productoRepositorio.save(input);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        Optional<Producto> producto = productoRepositorio.findById(id);
        if(producto.isPresent()){
            productoRepositorio.delete(producto.get());

            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
