package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import com.workconnect.model.Job;
import com.workconnect.model.JobStatus;
import com.workconnect.repository.JobRepository;
import com.workconnect.service.GeoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
    private final JobRepository jobRepository;
    private final GeoService geoService;

    public SearchController(JobRepository jobRepository, GeoService geoService) {
        this.jobRepository = jobRepository;
        this.geoService = geoService;
    }

    @GetMapping("/jobs-nearby")
    public ApiResponse jobsNearby(@RequestParam double lat, @RequestParam double lng, @RequestParam(defaultValue = "10") double maxKm) {
        List<Job> jobs = jobRepository.findByStatus(JobStatus.OPEN).stream()
                .filter(job -> job.getLatitude() != null && job.getLongitude() != null)
                .filter(job -> geoService.distanceKm(lat, lng, job.getLatitude(), job.getLongitude()) <= maxKm)
                .toList();
        return ApiResponse.ok("Nearby jobs fetched", jobs);
    }
}
