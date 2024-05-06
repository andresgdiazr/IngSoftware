package com.StartupFinanzas.producto.repositories;

import com.StartupFinanzas.producto.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
