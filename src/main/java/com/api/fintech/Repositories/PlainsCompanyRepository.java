package com.api.fintech.Repositories;

import com.api.fintech.Models.PlainsCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainsCompanyRepository extends JpaRepository<PlainsCompany, Long> {
}
