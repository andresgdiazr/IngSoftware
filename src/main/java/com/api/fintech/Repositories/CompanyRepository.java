package com.api.fintech.Repositories;

import com.api.fintech.Models.Client;
import com.api.fintech.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT u FROM Company u WHERE u.name = ?1")
    Optional<Company> findByName(String name);
    boolean existsByRif(String rif);
}
