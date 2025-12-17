package com.example.demo.entity;

public class TransferEvaluationResult {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Course sourceCourse;
    @ManyToOne
    private Course targetCourse;
    private Double overlapPercentage;
    private Integer creditHourDifference;
    private Boolean isEligibleForTransfer;
    private Timestamp evaluatedAt;
    private String notes;
}
