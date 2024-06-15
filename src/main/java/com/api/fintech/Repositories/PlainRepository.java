package com.api.fintech.Repositories;

import com.api.fintech.Models.Plain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainRepository extends JpaRepository<Plain, Long> {
}
