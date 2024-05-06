package com.StartupFinanzas.transacciones.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String referencia;
    private String cuenta;
    private Date fecha;
    private double monto;
    private double cargo;
    private String descripcion;
    private Channel canal;
    private String status;



}
