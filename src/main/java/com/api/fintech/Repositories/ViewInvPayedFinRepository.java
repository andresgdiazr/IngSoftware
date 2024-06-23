package com.api.fintech.Repositories;

import com.api.fintech.Models.ViewInvPayedFin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewInvPayedFinRepository extends JpaRepository<ViewInvPayedFin, Integer> {
}
