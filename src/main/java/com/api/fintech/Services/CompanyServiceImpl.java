package com.api.fintech.Services;

import com.api.fintech.Models.Company;
import com.api.fintech.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) throws Exception {
        if (company.getName() == null || company.getRif() == null) {
            throw new Exception("Required fields (name, rif) cannot be null");
        }

        if (companyRepository.existsByRif(company.getRif())) {
            throw new Exception("Company with RIF " + company.getRif() + " already exists");
        }

        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) throws Exception {
        Optional<Company> existingCompany = companyRepository.findById(company.getId());
        if (!existingCompany.isPresent()) {
            throw new Exception("Company not found with ID: " + company.getId());
        }

        Company updatedCompany = existingCompany.get();
        updatedCompany.setName(company.getName());
        updatedCompany.setRif(company.getRif());
        updatedCompany.setPassword(company.getPassword());
        updatedCompany.setEmail(company.getEmail());
        updatedCompany.setPhone(company.getPhone());
        updatedCompany.setStatus(company.getStatus());

        return companyRepository.save(updatedCompany);
    }

    @Override
    public void deleteCompany(Long id) throws Exception {
        if (!companyRepository.existsById(id)) {
            throw new Exception("Company not found with ID: " + id);
        }

        companyRepository.deleteById(id);
    }
}
