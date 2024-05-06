package com.StartupFinazas.cliente.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ClienteTransaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long transacId;
    @Transient
    private String nombreTransac;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cliente.class)
    @JoinColumn(name = "clienteId",nullable = true)
    private Cliente cliente;
}
