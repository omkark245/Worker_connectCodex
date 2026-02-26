package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import com.workconnect.model.Role;
import com.workconnect.model.WorkerStatus;
import com.workconnect.repository.JobRepository;
import com.workconnect.repository.UserRepository;
import com.workconnect.repository.WorkerProfileRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserRepository userRepository;
    private final WorkerProfileRepository workerProfileRepository;
    private final JobRepository jobRepository;

    public AdminController(UserRepository userRepository, WorkerProfileRepository workerProfileRepository, JobRepository jobRepository) {
        this.userRepository = userRepository;
        this.workerProfileRepository = workerProfileRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("/customers")
    public ApiResponse customers() {
        return ApiResponse.ok("Customer list", userRepository.findByRole(Role.CUSTOMER));
    }

    @GetMapping("/workers")
    public ApiResponse workers() {
        return ApiResponse.ok("Worker list", userRepository.findByRole(Role.WORKER));
    }

    @GetMapping("/jobs")
    public ApiResponse jobs() {
        return ApiResponse.ok("All jobs", jobRepository.findAll());
    }

    @PostMapping("/workers/{workerId}/approve")
    public ApiResponse approveWorker(@PathVariable Long workerId) {
        var profile = workerProfileRepository.findByUserId(workerId).orElseThrow();
        profile.setVerificationStatus(WorkerStatus.VERIFIED);
        return ApiResponse.ok("Worker approved", workerProfileRepository.save(profile));
    }

    @PostMapping("/workers/{workerId}/block")
    public ApiResponse blockWorker(@PathVariable Long workerId) {
        var profile = workerProfileRepository.findByUserId(workerId).orElseThrow();
        profile.setVerificationStatus(WorkerStatus.BLOCKED);
        profile.getUser().setActive(false);
        return ApiResponse.ok("Worker blocked and cannot login", workerProfileRepository.save(profile));
    }
}
