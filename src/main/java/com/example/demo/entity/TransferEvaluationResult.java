package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class TransferEvaluationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course sourceCourse;

    @ManyToOne
    private Course targetCourse;

    private Double overlapPercentage;
    private Boolean isEligibleForTransfer;
    private String notes;
    private LocalDateTime evaluationDate = LocalDateTime.now();
}