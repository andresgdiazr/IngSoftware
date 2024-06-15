package com.api.fintech.Services;

import com.api.fintech.Models.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> findAllCompanies();

    Company createCompany(Company company) throws Exception;

    Company updateCompany(Company company) throws Exception;

    void deleteCompany(Long id) throws Exception;
}

