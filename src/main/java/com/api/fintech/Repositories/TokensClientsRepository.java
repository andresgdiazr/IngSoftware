package com.api.fintech.Repositories;

import com.api.fintech.Models.TokensClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokensClientsRepository extends JpaRepository<TokensClients, Long> {
}
