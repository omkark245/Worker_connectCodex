package com.workconnect.dto;

public record CreateJobRequest(
        Long customerId,
        String title,
        String description,
        String skill,
        String imageUrl,
        Double latitude,
        Double longitude
) {}
