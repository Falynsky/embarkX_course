package com.falynsky.embarkx.app.services.impl;

import com.falynsky.embarkx.app.repositories.CompanyRepository;
import com.falynsky.embarkx.app.repositories.JobRepository;
import com.falynsky.embarkx.app.services.JobService;
import com.falynsky.embarkx.app.enities.Job;
import com.falynsky.embarkx.app.to.CreateJobTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;
    CompanyRepository companyRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(CreateJobTO createJobTO) {
        Job newJob = new Job();
        newJob.setTitle(createJobTO.getTitle());
        newJob.setDescription(createJobTO.getDescription());
        newJob.setMinSalary(createJobTO.getMinSalary());
        newJob.setMaxSalary(createJobTO.getMaxSalary());
        newJob.setLocation(createJobTO.getLocation());
        companyRepository.findById(createJobTO.getCompanyId())
                .ifPresentOrElse(
                        newJob::setCompany,
                        () -> {
                            throw new NoSuchElementException("Company not found");
                        });

        jobRepository.save(newJob);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void updateJob(Job existingJob, Job updatedJob) {
        existingJob.setTitle(updatedJob.getTitle() == null ? existingJob.getTitle() : updatedJob.getTitle());
        existingJob.setDescription(updatedJob.getDescription() == null ? existingJob.getDescription() : updatedJob.getDescription());
        existingJob.setMinSalary(updatedJob.getMinSalary() == null ? existingJob.getMinSalary() : updatedJob.getMinSalary());
        existingJob.setMaxSalary(updatedJob.getMaxSalary() == null ? existingJob.getMaxSalary() : updatedJob.getMaxSalary());
        existingJob.setLocation(updatedJob.getLocation() == null ? existingJob.getLocation() : updatedJob.getLocation());
        jobRepository.save(existingJob);
    }
}
