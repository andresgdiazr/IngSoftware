package com.api.fintech.Repositories;

import com.api.fintech.Models.DetailsPayfin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsPayfinRepository extends JpaRepository<DetailsPayfin, Long> {
}
