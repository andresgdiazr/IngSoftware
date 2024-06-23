package com.api.fintech.Controllers;

import com.api.fintech.Models.Client;
import com.api.fintech.Repositories.ClientRepository;
import com.api.fintech.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    IClientService clientService;


    @GetMapping("/all")
    public List<Client> findAll(){

        return clientService.mostrarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable long id){
        Optional<Client> cliente = clientService.findById(id);

        if(cliente.isPresent()){
            return new ResponseEntity<>(cliente.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Client input) throws Exception {
        Optional<Client> optionalCliente = clientService.findById(id);
        if (optionalCliente.isPresent()) {
            Client cliente = optionalCliente.get();
            cliente.setCedula(input.getCedula());
            cliente.setName(input.getName());
            cliente.setLastName(input.getLastName());
            cliente.setEmail(input.getEmail());
            cliente.setPassword(input.getPassword());
            cliente.setPhone(input.getPhone());
            cliente.setStatus(input.getStatus());
            cliente.setLocationId(input.getLocationId());
            Client updatedClient = clientService.actualizarCliente(cliente);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
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
