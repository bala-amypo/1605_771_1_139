package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TransferRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private University sourceUniversity;

    @ManyToOne(optional = false)
    private University targetUniversity;

    private double minimumOverlapPercentage;
    private int creditHourTolerance;
    private boolean active = true;
}