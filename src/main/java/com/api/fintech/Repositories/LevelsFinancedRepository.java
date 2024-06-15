package com.api.fintech.Repositories;

import com.api.fintech.Models.LevelsFinanced;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelsFinancedRepository extends JpaRepository<LevelsFinanced, Long> {
}
