package com.example.demo.entity;

public class TransferEvaluationResult {
    private Long id;
    private Boolean isEligibleForTransfer;
    private Double overlapPercentage;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getIsEligibleForTransfer() { return isEligibleForTransfer; }
    public void setIsEligibleForTransfer(Boolean eligible) { this.isEligibleForTransfer = eligible; }

    public Double getOverlapPercentage() { return overlapPercentage; }
    public void setOverlapPercentage(Double overlapPercentage) { this.overlapPercentage = overlapPercentage; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
