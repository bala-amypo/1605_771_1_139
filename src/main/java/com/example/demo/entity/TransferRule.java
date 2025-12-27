package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TransferRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private University sourceUniversity;

    @ManyToOne
    private University targetUniversity;

    private double minimumOverlapPercentage;
    private int creditHourTolerance; // e.g., 0, 1, 2
    private boolean active = true;
}