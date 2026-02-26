package com.workconnect.dto;

public record SendMessageRequest(Long workerId, Long customerId, Long jobId, String content) {}
