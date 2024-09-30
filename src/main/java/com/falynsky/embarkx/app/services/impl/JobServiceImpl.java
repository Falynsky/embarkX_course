package com.falynsky.embarkx.app.services.impl;

import com.falynsky.embarkx.app.repositories.CompanyRepository;
import com.falynsky.embarkx.app.repositories.JobRepository;
import com.falynsky.embarkx.app.services.JobService;
import com.falynsky.embarkx.app.enities.Job;
import com.falynsky.embarkx.app.dto.JobDTO;
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
    public void createJob(JobDTO jobDTO) {
        Job newJob = new Job();
        newJob.setTitle(jobDTO.getTitle());
        newJob.setDescription(jobDTO.getDescription());
        newJob.setMinSalary(jobDTO.getMinSalary());
        newJob.setMaxSalary(jobDTO.getMaxSalary());
        newJob.setLocation(jobDTO.getLocation());
        companyRepository.findById(jobDTO.getCompanyId())
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
