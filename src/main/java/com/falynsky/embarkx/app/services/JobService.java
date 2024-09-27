package com.falynsky.embarkx.app.services;

import com.falynsky.embarkx.app.enities.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    Job findById(Long id);

    void createJob(Job job);

    void deleteJob(Long id);

    void updateJob(Job existingJob, Job job);
}
