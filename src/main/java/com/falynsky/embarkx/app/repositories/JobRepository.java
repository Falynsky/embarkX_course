package com.falynsky.embarkx.app.repositories;

import com.falynsky.embarkx.app.enities.Company;
import com.falynsky.embarkx.app.enities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByCompany(Company company);

    List<Job> findByCompanyId(Long id);
}
