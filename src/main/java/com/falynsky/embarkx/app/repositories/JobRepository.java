package com.falynsky.embarkx.app.repositories;

import com.falynsky.embarkx.app.enities.Company;
import com.falynsky.embarkx.app.enities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByCompany(Company company);

    @Query("SELECT j FROM Job j WHERE j.company.id = :id")
    List<Job> findByCompanyId(Long id);
}
