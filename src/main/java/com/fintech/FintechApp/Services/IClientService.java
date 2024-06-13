package com.fintech.FintechApp.Services;

import com.fintech.FintechApp.Models.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client crearCliente(Client cliente);
    List<Client> mostrarClientes();
    Optional<Client> findById(Long id);

}
