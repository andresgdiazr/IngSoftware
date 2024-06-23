package com.api.fintech.Repositories;

import com.api.fintech.Models.CategoryProd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryProdRepository extends JpaRepository<CategoryProd, Long> {
}
