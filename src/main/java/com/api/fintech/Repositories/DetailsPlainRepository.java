package com.api.fintech.Repositories;

import com.api.fintech.Models.DetailsPlain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsPlainRepository extends JpaRepository<DetailsPlain, Long> {
}
