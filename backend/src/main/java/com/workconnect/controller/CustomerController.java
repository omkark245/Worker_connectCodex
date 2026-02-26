package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import com.workconnect.dto.CreateJobRequest;
import com.workconnect.model.Job;
import com.workconnect.model.JobStatus;
import com.workconnect.model.User;
import com.workconnect.repository.JobRepository;
import com.workconnect.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public CustomerController(UserRepository userRepository, JobRepository jobRepository) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping("/jobs")
    public ApiResponse createJob(@RequestBody CreateJobRequest request) {
        User customer = userRepository.findById(request.customerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Job job = new Job();
        job.setCustomer(customer);
        job.setTitle(request.title());
        job.setDescription(request.description());
        job.setSkill(request.skill());
        job.setImageUrl(request.imageUrl());
        job.setLatitude(request.latitude());
        job.setLongitude(request.longitude());
        return ApiResponse.ok("Job posted", jobRepository.save(job));
    }

    @GetMapping("/jobs/{customerId}")
    public ApiResponse getMyJobs(@PathVariable Long customerId) {
        return ApiResponse.ok("Jobs fetched", jobRepository.findByCustomerId(customerId));
    }

    @PutMapping("/jobs/{jobId}/status/{status}")
    public ApiResponse updateJobStatus(@PathVariable Long jobId, @PathVariable JobStatus status) {
        Job job = jobRepository.findById(jobId).orElseThrow();
        job.setStatus(status);
        if (status == JobStatus.COMPLETED) {
            jobRepository.delete(job);
            return ApiResponse.ok("Work done, job deleted automatically", null);
        }
        return ApiResponse.ok("Job updated", jobRepository.save(job));
    }

    @DeleteMapping("/jobs/{jobId}")
    public ApiResponse deleteJob(@PathVariable Long jobId) {
        jobRepository.deleteById(jobId);
        return ApiResponse.ok("Job deleted", null);
    }
}
