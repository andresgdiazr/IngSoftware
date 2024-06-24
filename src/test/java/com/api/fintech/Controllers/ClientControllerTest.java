package com.api.fintech.Controllers;

import com.api.fintech.Services.IClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @MockBean
    private IClientService clientService;

    @BeforeEach
    void setUp() {
        System.out.println("Antes de la prueba");
    }
    @Test
    void testGetClient() {
        System.out.println("Durante de la prueba");
    }

    @Test
    void testAgregarCliente() {
        System.out.println("Durante de la prueba");

    }




}