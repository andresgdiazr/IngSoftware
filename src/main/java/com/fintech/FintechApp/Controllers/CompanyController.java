package com.fintech.FintechApp.Controllers;

import com.fintech.FintechApp.Models.Client;
import com.fintech.FintechApp.Models.Company;
import com.fintech.FintechApp.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping()
    public List<Company> findAll(){

        return companyRepository.findAll();
    }
}
