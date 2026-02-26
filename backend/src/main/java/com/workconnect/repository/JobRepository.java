package com.workconnect.repository;

import com.workconnect.model.Job;
import com.workconnect.model.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByStatus(JobStatus status);
    List<Job> findByCustomerId(Long customerId);
}
