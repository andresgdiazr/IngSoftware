package com.api.fintech.Repositories;

import com.api.fintech.Models.Client;
import com.api.fintech.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<Client> findByName(String name);


}
