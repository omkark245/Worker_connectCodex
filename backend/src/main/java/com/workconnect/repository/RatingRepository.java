package com.workconnect.repository;

import com.workconnect.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByWorkerId(Long workerId);
}
