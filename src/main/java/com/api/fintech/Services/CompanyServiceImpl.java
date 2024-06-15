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
        // Implement basic validation here (e.g., check for required fields)
        if (company.getName() == null || company.getRif() == null) {
            throw new Exception("Required fields (name, rif) cannot be null");
        }

        // Check for unique constraints (e.g., rif) before saving
        if (companyRepository.existsByRif(company.getRif())) {
            throw new Exception("Company with RIF " + company.getRif() + " already exists");
        }

        companyRepository.save(company);
        return company;
    }

    @Override
    public Company updateCompany(Company company) throws Exception {
        // Check if company exists before updating
        Optional<Company> existingCompany = companyRepository.findById(Long.valueOf(company.getId()));
        if (!existingCompany.isPresent()) {
            throw new Exception("Company not found with ID: " + company.getId());
        }

        // Update company details
        existingCompany.get().setName(company.getName());
        existingCompany.get().setRif(company.getRif()); // Update with caution if RIF is not meant to be changed
        existingCompany.get().setPassword(company.getPassword());
        existingCompany.get().setEmail(company.getEmail());
        existingCompany.get().setPhone(company.getPhone());
        existingCompany.get().setStatus(company.getStatus());

        companyRepository.save(existingCompany.get());
        return existingCompany.get();
    }

    @Override
    public void deleteCompany(Long id) throws Exception {
        // Check if company exists before deleting
        if (!companyRepository.existsById(id)) {
            throw new Exception("Company not found with ID: " + id);
        }

        companyRepository.deleteById(id);
    }
}
