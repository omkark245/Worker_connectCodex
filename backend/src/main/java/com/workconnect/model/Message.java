package com.workconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Job job;
    @ManyToOne
    private User customer;
    @ManyToOne
    private User worker;
    @Column(length = 2000)
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
