package com.api.fintech.Repositories;

import com.api.fintech.Models.DetailsFinanced;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsFinancedRepository extends JpaRepository<DetailsFinanced, Long> {
}
