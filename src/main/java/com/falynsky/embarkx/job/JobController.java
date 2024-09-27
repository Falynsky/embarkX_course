package com.falynsky.embarkx.job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping()
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(job.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> find(@PathVariable Long id) {
        Job job = jobService.findById(id);

        if (job == null) {
            throw new NoSuchElementException("Job not found");
        }

        return ResponseEntity.ok(job);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id) {
        Job job = jobService.findById(id);

        if (job == null) {
            throw new NoSuchElementException("Job not found");
        }

        jobService.deleteJob(id);

        return ResponseEntity.ok().build();
    }

//    @PutMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateJob(@PathVariable Long id, @RequestBody Job job) {
        Job existingJob = jobService.findById(id);

        if (existingJob == null) {
            throw new NoSuchElementException("Job not found");
        }

        jobService.updateJob(existingJob, job);

        return ResponseEntity.ok().build();
    }
}
