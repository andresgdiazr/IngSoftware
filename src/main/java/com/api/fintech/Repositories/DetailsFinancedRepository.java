package com.api.fintech.Repositories;

import com.api.fintech.Models.DetailsFinanced;
import com.api.fintech.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailsFinancedRepository extends JpaRepository<DetailsFinanced, Long> {
    @Query("SELECT u FROM DetailsFinanced u WHERE u.clientId = ?1")
    Optional<DetailsFinanced> findByClientId(Long id);
}
