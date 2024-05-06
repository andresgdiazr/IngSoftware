package com.StartupFinazas.cliente.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ced;
    private String nombre;
    private String apellido;
    private String telf;
    private String cuenta;
    private String direccion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ClienteProducto> productoList;
    @Transient
    private List<?> transacList;

}
