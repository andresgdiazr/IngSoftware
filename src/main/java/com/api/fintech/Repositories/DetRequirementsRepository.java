package com.api.fintech.Repositories;

import com.api.fintech.Models.DetRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetRequirementsRepository extends JpaRepository<DetRequirements, Long> {
}
