package com.falynsky.embarkx.job.impl;

import com.falynsky.embarkx.job.Job;
import com.falynsky.embarkx.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job findById(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public void updateJob(Job existingJob, Job updatedJob) {
        jobs.stream()
                .filter(job -> job.getId().equals(existingJob.getId()))
                .forEach(job -> {
                    job.setTitle(updatedJob.getTitle());
                    job.setDescription(updatedJob.getDescription());
                    job.setMinSalary(updatedJob.getMinSalary());
                    job.setMaxSalary(updatedJob.getMaxSalary());
                    job.setLocation(updatedJob.getLocation());
                    job.setVersion(existingJob.getVersion() + 1L);
                });
    }
}
