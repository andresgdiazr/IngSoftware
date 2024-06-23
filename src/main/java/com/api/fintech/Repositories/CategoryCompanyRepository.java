package com.api.fintech.Repositories;

import com.api.fintech.Models.CategoryComp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCompanyRepository extends JpaRepository<CategoryComp, Long> {
}
