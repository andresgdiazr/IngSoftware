package com.fintech.FintechApp.Controllers;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Models.User;
import com.fintech.FintechApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UsersControllers {
    @Autowired
    UserRepository userRepository;


    @GetMapping()
    public List<User> findAll(){

        return userRepository.findAll();
    }
    @GetMapping(value = "/welcome")
    public String welcome(){

        return "Saludos desde el backend";
    }
}
