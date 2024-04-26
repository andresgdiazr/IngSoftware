package com.StartupFinazas.cliente.repositories;

import com.StartupFinazas.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
