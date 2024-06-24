package com.api.fintech.Services;

import com.api.fintech.Models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    Optional<User>findUserByname(String name);
}
