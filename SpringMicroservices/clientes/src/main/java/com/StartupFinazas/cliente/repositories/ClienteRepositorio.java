package com.StartupFinazas.cliente.repositories;

import com.StartupFinazas.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
        @Query("SELECT c FROM Cliente c WHERE c.ced =:ced")
        Cliente findByCed(String ced);

}
