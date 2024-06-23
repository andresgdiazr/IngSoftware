package com.fintech.FintechApp.Services;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client crearCliente(Client cliente) {
        clientRepository.save(cliente);
        return cliente;
    }




    @Override
    public List<Client> mostrarClientes() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
}
