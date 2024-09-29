package com.falynsky.embarkx.app.services;


import com.falynsky.embarkx.app.enities.Company;
import com.falynsky.embarkx.app.enities.Job;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    List<Job> findJobsByCompanyId(Long id);

    void createCompany(Company company);

    void deleteCompany(Long id);

    void updateCompany(Company company, Long id);

}
