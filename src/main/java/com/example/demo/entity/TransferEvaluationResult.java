package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_evaluation_results")
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private Double totalTransferableCredits;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String remarks;

    public TransferEvaluationResult() {
    }

    public TransferEvaluationResult(Long id, String studentId, Double totalTransferableCredits, String status, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.totalTransferableCredits = totalTransferableCredits;
        this.status = status;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Double getTotalTransferableCredits() {
        return totalTransferableCredits;
    }

    public void setTotalTransferableCredits(Double totalTransferableCredits) {
        this.totalTransferableCredits = totalTransferableCredits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
