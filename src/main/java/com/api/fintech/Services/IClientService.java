package com.api.fintech.Services;

import com.api.fintech.Models.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client crearCliente(Client cliente) throws Exception;
    List<Client> mostrarClientes();
    Optional<Client> findById(Long id);
    Client actualizarCliente(Client cliente) throws Exception;
    void eliminarCliente(Long id) throws Exception;
}