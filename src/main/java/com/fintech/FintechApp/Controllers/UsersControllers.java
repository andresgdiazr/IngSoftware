package com.fintech.FintechApp.Controllers;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Models.User;
import com.fintech.FintechApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
        return "Welcome from protected endPoint";
    }
}
