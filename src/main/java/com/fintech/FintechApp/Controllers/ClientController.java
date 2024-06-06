package com.fintech.FintechApp.Controllers;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping()
    public List<Client> findAll(){

        return clientRepository.findAll();
    }

}
