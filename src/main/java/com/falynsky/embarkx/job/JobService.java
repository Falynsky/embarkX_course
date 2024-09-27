package com.falynsky.embarkx.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    Job findById(Long id);

    void createJob(Job job);

    void deleteJob(Long id);

    void updateJob(Job existingJob, Job job);
}
