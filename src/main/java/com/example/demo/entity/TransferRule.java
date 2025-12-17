package com.example.demo.entity;

public class TransferRule {
    @Id @GeneratedValue
    private Long id;
    private Course course;
    private String topicName;
    private Double weightPercentage;
}
