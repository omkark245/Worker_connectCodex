package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import com.workconnect.dto.CreateRatingRequest;
import com.workconnect.model.Rating;
import com.workconnect.repository.JobRepository;
import com.workconnect.repository.RatingRepository;
import com.workconnect.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public RatingController(RatingRepository ratingRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    @PostMapping
    public ApiResponse create(@RequestBody CreateRatingRequest request) {
        Rating rating = new Rating();
        rating.setCustomer(userRepository.findById(request.customerId()).orElseThrow());
        rating.setWorker(userRepository.findById(request.workerId()).orElseThrow());
        rating.setJob(jobRepository.findById(request.jobId()).orElseThrow());
        rating.setScore(request.score());
        rating.setComment(request.comment());
        return ApiResponse.ok("Rating submitted", ratingRepository.save(rating));
    }

    @GetMapping("/{workerId}")
    public ApiResponse getWorkerRatings(@PathVariable Long workerId) {
        return ApiResponse.ok("Worker ratings", ratingRepository.findByWorkerId(workerId));
    }
}
