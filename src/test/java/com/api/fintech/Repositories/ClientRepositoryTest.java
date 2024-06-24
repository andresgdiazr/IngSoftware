package com.api.fintech.Repositories;

import com.api.fintech.Models.Client;
import com.api.fintech.Services.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    JwtService jwtService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Client client =
                Client.builder()
                        .name("Oscar")
                        .lastName("Gonzalez")
                        .phone("2345")
                        .cedula("111111")
                        .status("activo")
                        .email("oscar@gmail")
                        .password("12345")
                        .locationId(1)
                        .build();
        entityManager.persist(client);
        Mockito.when(clientRepository.findByName("Oscar")).thenReturn(Optional.ofNullable(client));
    }

    @Test
    public void findByName(String name) {



        Optional<Client> cliente = clientRepository.findByName(name);
        assertEquals(cliente.get().getName(),"Oscar");

    }
}