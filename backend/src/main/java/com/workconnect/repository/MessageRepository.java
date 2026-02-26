package com.workconnect.repository;

import com.workconnect.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByJobId(Long jobId);
}
