package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "performance_summary")
public class PerformanceSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long employeeId;

    @Column(length = 5000000)
    private String selfReviewText;

    private LocalDateTime selfReviewTimestamp;

    @Column(length = 50000)
    private String managerReviewText;

    private double managerRating;

    private LocalDateTime managerReviewTimestamp;

    @Column(nullable = false)
    private double performanceScore;

}