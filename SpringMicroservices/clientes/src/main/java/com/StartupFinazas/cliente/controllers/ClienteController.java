package com.StartupFinazas.cliente.controllers;

import com.StartupFinazas.cliente.entities.Cliente;
import com.StartupFinazas.cliente.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    @GetMapping()
    public List<Cliente> findAll(){

        return clienteRepositorio.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id){
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Cliente input){
        Optional<Cliente> cliente = clienteRepositorio.findById(id);
        if(cliente.isPresent()){
            Cliente cliente1 = cliente.get();
            cliente1.setNombre(input.getNombre());
            cliente1.setApellido(input.getApellido());
            cliente1.setTelf(input.getTelf());
            cliente1.setDireccion(input.getDireccion());
            cliente1.setCed(input.getCed());
            Cliente salvar = clienteRepositorio.save(cliente1);
            return  new ResponseEntity<>(salvar,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Cliente input){
        Cliente cliente = clienteRepositorio.save(input);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){

        return null;
    }


}
