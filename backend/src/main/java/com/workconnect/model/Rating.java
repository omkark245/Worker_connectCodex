package com.workconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User customer;
    @ManyToOne
    private User worker;
    @ManyToOne
    private Job job;
    private Integer score;
    private String comment;
}
