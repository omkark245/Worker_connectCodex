package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import com.workconnect.dto.SendMessageRequest;
import com.workconnect.model.Message;
import com.workconnect.repository.JobRepository;
import com.workconnect.repository.MessageRepository;
import com.workconnect.repository.UserRepository;
import com.workconnect.service.WorkerMessagingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkerController {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final WorkerMessagingService workerMessagingService;

    public WorkerController(MessageRepository messageRepository, UserRepository userRepository, JobRepository jobRepository, WorkerMessagingService workerMessagingService) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.workerMessagingService = workerMessagingService;
    }

    @PostMapping("/messages")
    public ApiResponse sendMessage(@RequestBody SendMessageRequest request) {
        String billingMessage = workerMessagingService.chargeMessage(request.workerId());
        Message message = new Message();
        message.setJob(jobRepository.findById(request.jobId()).orElseThrow());
        message.setWorker(userRepository.findById(request.workerId()).orElseThrow());
        message.setCustomer(userRepository.findById(request.customerId()).orElseThrow());
        message.setContent(request.content());
        messageRepository.save(message);
        return ApiResponse.ok(billingMessage, message);
    }
}
