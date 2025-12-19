package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "transfer_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = {"sourceUniversity", "targetUniversity"})
)
public class TransferRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sourceUniversity;

    @Column(nullable = false)
    private String targetUniversity;

    @Column(nullable = false)
    private Integer maxCredits;

    public TransferRule() {
    }

    public TransferRule(Long id, String sourceUniversity, String targetUniversity, Integer maxCredits) {
        this.id = id;
        this.sourceUniversity = sourceUniversity;
        this.targetUniversity = targetUniversity;
        this.maxCredits = maxCredits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceUniversity() {
        return sourceUniversity;
    }

    public void setSourceUniversity(String sourceUniversity) {
        this.sourceUniversity = sourceUniversity;
    }

    public String getTargetUniversity() {
        return targetUniversity;
    }

    public void setTargetUniversity(String targetUniversity) {
        this.targetUniversity = targetUniversity;
    }

    public Integer getMaxCredits() {
        return maxCredits;
    }

    public void setMaxCredits(Integer maxCredits) {
        this.maxCredits = maxCredits;
    }
}
