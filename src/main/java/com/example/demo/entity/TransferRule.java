package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_rules")
public class TransferRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sourceUniversityId;
    private Long targetUniversityId;

    private Long sourceCourseId;
    private Long targetCourseId;

    private Integer creditHourTolerance;
    private Float minimumOverlapPercentage;

    // 🔥 IMPORTANT: FIELD NAME MUST BE "active"
    @Column(name = "is_active")
    private boolean active;

    // getters & setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
