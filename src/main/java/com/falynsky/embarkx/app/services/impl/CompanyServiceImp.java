package com.falynsky.embarkx.app.services.impl;

import com.falynsky.embarkx.app.enities.Company;
import com.falynsky.embarkx.app.enities.Job;
import com.falynsky.embarkx.app.repositories.CompanyRepository;
import com.falynsky.embarkx.app.repositories.JobRepository;
import com.falynsky.embarkx.app.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyServiceImp implements CompanyService {

    private final CompanyRepository companyRepository;
private final JobRepository jobRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public List<Job> findJobsByCompanyId(Long id) {
        List<Job> jobs = jobRepository.findByCompanyId(id);

        if (jobs == null) {
            throw new NoSuchElementException("No jobs found for selected company id");
        }

        return jobs;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void updateCompany(Company company, Long id) {
        Optional<Company> byId = companyRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NoSuchElementException("Company not found");
        }
        Company updatedCompany = byId.get();
        updatedCompany.setName(company.getName() == null ? updatedCompany.getName() : company.getName());
        updatedCompany.setCity(company.getCity() == null ? updatedCompany.getCity() : company.getCity());
        companyRepository.save(updatedCompany);
    }
}
