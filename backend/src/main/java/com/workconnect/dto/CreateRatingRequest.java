package com.workconnect.dto;

public record CreateRatingRequest(Long customerId, Long workerId, Long jobId, Integer score, String comment) {}
