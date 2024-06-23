package com.api.fintech.Repositories;

import com.api.fintech.Models.ViewInvDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewInvDetailsRepository extends JpaRepository<ViewInvDetails, Integer> {
}
