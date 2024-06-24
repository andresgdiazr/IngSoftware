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
import com.api.fintech.exceptions.ClientNotFoundException;
import com.api.fintech.exceptions.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponseException;
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
    public ResponseEntity<DataDtoLogin> login(@RequestBody LoginRequest request) throws CompanyNotFoundException {

        DataDtoLogin data = new DataDtoLogin();

        AuthResponse respuesta = authService.login(request);
        Optional<User> user = userService.findUserByname(request.getUsername());

        if (user.isPresent()) {
            Role userRole = user.get().getRole();
            if (userRole.equals(Role.TIENDA)) {
                Optional<Company> company = companyService.findByName(request.getUsername());
                if (company.isPresent()){
                    data.setUsername(company.get().getName());
                    data.setPhone(company.get().getPhone());
                    data.setRif(company.get().getRif());
                    data.setToken(respuesta.getToken());
                    data.setEmail(company.get().getEmail());
                    data.setRole(userRole);
                    data.setStatus(company.get().getStatus());
                }else{
                    throw new CompanyNotFoundException("No se encontró la compañia");
                }
                return new ResponseEntity<>(data, HttpStatus.OK);
            } else if (userRole.equals(Role.CLIENTE)) {
                Optional<Client> client = clientService.findByName(request.getUsername());
                if(client.isPresent()){
                    data.setUsername(client.get().getName());
                    data.setLastname(client.get().getLastName());
                    data.setCedula(client.get().getCedula());
                    data.setToken(respuesta.getToken());
                    data.setRole(userRole);
                    data.setStatus(client.get().getStatus());
                }else{
                    throw new ClientNotFoundException("No se encontró el cliente");
                }

            }else if (userRole.equals(Role.FINTECH)){
                data.setUsername(user.get().getUsername());
                data.setRole(user.get().getRole());
                data.setToken(respuesta.getToken());
            }else{
                throw new ErrorResponseException(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) throws Exception {

        AuthResponse user = authService.register(request);

        switch (user.getRole()){

            case Role.CLIENTE:
                Client cliente =new Client();
                cliente.setName(request.getUsername());
                cliente.setLocationId(request.getLocationId());
                cliente.setEmail(request.getEmail());
                cliente.setPassword(request.getPassword());
                cliente.setPhone(request.getPhone());
                cliente.setStatus("A");
                cliente.setRole(user.getRole());
                cliente.setCedula(request.getCedula());
                cliente.setLastName(request.getLastname());
                try{
                    clientService.crearCliente(cliente);
                }catch (Exception e){
                    return new ResponseEntity<>(user, HttpStatus.CONFLICT);
                }
                break;
            case Role.TIENDA:
                Company company = new Company();
                company.setEmail(request.getEmail());
                company.setRif(request.getRif());
                company.setCategoryCompsId(request.getCategoryCompsId());
                company.setLocationId(request.getLocationId());
                company.setPhone(request.getPhone());
                company.setPassword(passwordEncoder.encode(request.getPassword()));
                company.setStatus("A");
                company.setName(request.getUsername());
                try{
                    companyService.createCompany(company);
                }catch (Exception e){
                    return new ResponseEntity<>(user, HttpStatus.CONFLICT);
                }
            case Role.FINTECH:
                break;
            default:
                throw new Exception("No se encontro un role valido al registrar el usuario");
        }


        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
