package com.api.fintech.Services;

import com.api.fintech.exceptions.ClientNotFoundException;
import com.api.fintech.Models.Client;
import com.api.fintech.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client crearCliente(Client cliente) throws Exception {
        // Implement validation logic here (e.g., check for required fields)

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

    @Override
    public Client actualizarCliente(Client cliente) throws Exception {
        // Implement validation logic here (e.g., check if client exists)

        Optional<Client> existingClient = clientRepository.findById(Long.valueOf(cliente.getId()));
        if (!existingClient.isPresent()) {
            throw new ClientNotFoundException("Cliente no encontrado con ID: " + cliente.getId());
        }

        clientRepository.save(cliente);
        return cliente;
    }

    @Override
    public void eliminarCliente(Long id) throws Exception {
        // Implement validation logic here (e.g., check if client exists)

        clientRepository.deleteById(id);
    }
}
