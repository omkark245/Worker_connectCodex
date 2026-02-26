package com.workconnect.service;

import com.workconnect.model.WorkerProfile;
import com.workconnect.repository.WorkerProfileRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WorkerMessagingService {
    private final WorkerProfileRepository workerProfileRepository;
    private final int freeLimit;

    public WorkerMessagingService(WorkerProfileRepository workerProfileRepository,
                                  @Value("${app.free-message-limit:10}") int freeLimit) {
        this.workerProfileRepository = workerProfileRepository;
        this.freeLimit = freeLimit;
    }

    public String chargeMessage(Long workerId) {
        WorkerProfile profile = workerProfileRepository.findByUserId(workerId)
                .orElseThrow(() -> new IllegalArgumentException("Worker profile not found"));

        if (profile.getFreeMessageUsed() < freeLimit) {
            profile.setFreeMessageUsed(profile.getFreeMessageUsed() + 1);
            workerProfileRepository.save(profile);
            return "Message sent using free quota";
        }

        profile.setPaidMessages(profile.getPaidMessages() + 1);
        workerProfileRepository.save(profile);
        return "Free quota exhausted. Charged ₹10 using Razorpay wallet flow.";
    }
}
