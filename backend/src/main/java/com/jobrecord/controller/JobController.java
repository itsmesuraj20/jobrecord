package com.jobrecord.controller;

import com.jobrecord.model.Job;
import com.jobrecord.model.JobStatus;
import com.jobrecord.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Job createJob(@Valid @RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @Valid @RequestBody Job jobDetails) {
        Optional<Job> job = jobService.getJobById(id);
        if (job.isPresent()) {
            Job existingJob = job.get();
            existingJob.setCompanyName(jobDetails.getCompanyName());
            existingJob.setPosition(jobDetails.getPosition());
            existingJob.setLocation(jobDetails.getLocation());
            existingJob.setStatus(jobDetails.getStatus());
            existingJob.setApplicationDate(jobDetails.getApplicationDate());
            existingJob.setJobUrl(jobDetails.getJobUrl());
            existingJob.setSalaryRange(jobDetails.getSalaryRange());
            existingJob.setRecruiterName(jobDetails.getRecruiterName());
            existingJob.setRecruiterEmail(jobDetails.getRecruiterEmail());
            existingJob.setRecruiterPhone(jobDetails.getRecruiterPhone());
            existingJob.setNotes(jobDetails.getNotes());
            existingJob.setFollowUpDate(jobDetails.getFollowUpDate());
            return ResponseEntity.ok(jobService.saveJob(existingJob));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        if (job.isPresent()) {
            jobService.deleteJob(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status/{status}")
    public List<Job> getJobsByStatus(@PathVariable JobStatus status) {
        return jobService.getJobsByStatus(status);
    }

    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam(required = false) String companyName,
                               @RequestParam(required = false) String position,
                               @RequestParam(required = false) JobStatus status) {
        return jobService.searchJobs(companyName, position, status);
    }
}