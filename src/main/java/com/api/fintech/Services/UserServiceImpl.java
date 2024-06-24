package com.api.fintech.Services;

import com.api.fintech.Models.User;
import com.api.fintech.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<User> findUserByname(String name) {
        return userRepository.findByName(name);
    }
}
