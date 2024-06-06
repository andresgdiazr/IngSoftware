package com.fintech.FintechApp.Repositories;

import com.fintech.FintechApp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
