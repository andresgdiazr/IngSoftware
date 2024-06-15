package com.api.fintech.Repositories;

import com.api.fintech.Models.TokenComp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenCompRepository extends JpaRepository<TokenComp, Long> {
}
