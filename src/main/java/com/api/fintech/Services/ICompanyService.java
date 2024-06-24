package com.api.fintech.Services;

import com.api.fintech.Models.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {
    List<Company> findAllCompanies();

    Company createCompany(Company company) throws Exception;

    Company updateCompany(Company company) throws Exception;

    Optional<Company> findByName(String name);

    void deleteCompany(Long id) throws Exception;
}

