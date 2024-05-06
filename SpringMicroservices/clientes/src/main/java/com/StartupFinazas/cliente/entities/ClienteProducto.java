package com.StartupFinazas.cliente.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ClienteProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long productId;
    @Transient
    private String nombreProducto;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cliente.class)
    @JoinColumn(name = "clienteId",nullable = true)
    private Cliente cliente;


}
