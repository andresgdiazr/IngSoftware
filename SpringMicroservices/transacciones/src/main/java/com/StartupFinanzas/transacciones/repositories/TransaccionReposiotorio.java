package com.StartupFinanzas.transacciones.repositories;

import com.StartupFinanzas.transacciones.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransaccionReposiotorio extends JpaRepository<Transaccion,Long> {

    @Query("Select c from Transaccion c Where c.cuenta = ?1")
    List<Transaccion> findByCuenta(String cuenta);


}
