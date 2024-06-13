package com.fintech.FintechApp.Services;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public void save(Client cliente) {
        clientRepository.save(cliente);
    }

    @Override
    public Client update(Long id) {
        return null;
    }
}
