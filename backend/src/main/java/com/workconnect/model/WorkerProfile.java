package com.workconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private User user;

    private String skills;
    private String city;
    private String area;
    private Double ratingAvg = 0.0;
    private Integer freeMessageUsed = 0;
    private Integer paidMessages = 0;

    @Enumerated(EnumType.STRING)
    private WorkerStatus verificationStatus = WorkerStatus.PENDING;
}
