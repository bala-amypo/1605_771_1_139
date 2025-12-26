package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransferEvaluationResult {

    @Id
    private Long id;

    private String studentId;
    private int totalTransferableCredits;
    private String status;
    private String remarks;

    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getTotalTransferableCredits() {
        return totalTransferableCredits;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }
}
