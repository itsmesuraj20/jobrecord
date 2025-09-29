package com.jobrecord.service;

import com.jobrecord.model.Job;
import com.jobrecord.model.JobStatus;
import com.jobrecord.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getJobsByStatus(JobStatus status) {
        return jobRepository.findByStatus(status);
    }

    public List<Job> searchJobs(String companyName, String position, JobStatus status) {
        return jobRepository.findJobsWithFilters(companyName, position, status);
    }

    public List<Job> getJobsByCompany(String companyName) {
        return jobRepository.findByCompanyNameContainingIgnoreCase(companyName);
    }

    public List<Job> getJobsByPosition(String position) {
        return jobRepository.findByPositionContainingIgnoreCase(position);
    }

    public long countJobsByStatus(JobStatus status) {
        return jobRepository.countByStatus(status);
    }
}