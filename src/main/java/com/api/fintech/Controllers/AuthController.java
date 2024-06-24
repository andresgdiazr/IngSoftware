package com.api.fintech.Controllers;

import com.api.fintech.DTO.DataCompDTO;
import com.api.fintech.DTO.DataDtoLogin;
import com.api.fintech.Jwt.AuthResponse;
import com.api.fintech.Jwt.LoginRequest;
import com.api.fintech.Jwt.RegisterRequest;
import com.api.fintech.Models.Client;
import com.api.fintech.Models.Company;
import com.api.fintech.Models.Role;
import com.api.fintech.Models.User;
import com.api.fintech.Repositories.UserRepository;
import com.api.fintech.Services.AuthService;
import com.api.fintech.Services.IClientService;
import com.api.fintech.Services.ICompanyService;
import com.api.fintech.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    IClientService clientService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<DataDtoLogin> login(@RequestBody LoginRequest request) {

        DataDtoLogin data = new DataDtoLogin();

        DataCompDTO comp = new DataCompDTO();
        AuthResponse respuesta = authService.login(request);
        Optional<Client> client = clientService.findByName(request.getUsername());
        Optional<User> user = userService.findUserByname(request.getUsername());
        Optional<Company> company = companyService.findByName(data.getUsername());
        if (user.isPresent()) {
            if (user.get().getRole().equals("TIENDA")) {
                comp.setName(company.get().getName());
                comp.setCompanyId(company.get().getCompanyId());
                comp.setPhone(company.get().getPhone());
                comp.setRif(company.get().getRif());
                comp.setToken(respuesta.getToken());
                comp.setEmail(company.get().getEmail());
                comp.setStatus(company.get().getStatus());


            } else if (client.get().getRole().equals("CLIENTE")) {
                data.setLastname(client.get().getLastName());
                data.setUsername(client.get().getName());
                data.setCedula(client.get().getCedula());
                data.setToken(respuesta.getToken());
                data.setRole(client.get().getRole());
                data.setStatus(client.get().getStatus());

            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) throws Exception {

        AuthResponse user = authService.register(request);
        switch (request.getRole()){

            case Role.CLIENTE:
                Client cliente =new Client();
                cliente.setName(request.getUsername());
                cliente.setStatus(request.getStatus());
                cliente.setRole(request.getRole());
                cliente.setCedula(request.getCedula());
                cliente.setLastName(request.getLastname());
                clientService.crearCliente(cliente);

                break;
            case Role.TIENDA:
                Company company = new Company();
                company.setEmail(request.getEmail());
                company.setRif(request.getRif());
                company.setCategoryCompsId(request.getCategoryCompsId());
                company.setLocationId(request.getLocationId());
                company.setPhone(request.getPhone());
                company.setPassword(passwordEncoder.encode(request.getPassword()));
                company.setStatus(request.getStatus());
                company.setName(request.getUsername());
                companyService.createCompany(company);

        }


        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
