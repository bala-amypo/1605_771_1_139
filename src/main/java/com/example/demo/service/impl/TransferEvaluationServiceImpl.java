package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.CourseContentTopicService;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    private final TransferEvaluationResultRepository resultRepo;
    private final TransferRuleRepository ruleRepo;
    private final CourseContentTopicService topicService;

    // Manual Constructor Injection
    public TransferEvaluationServiceImpl(TransferEvaluationResultRepository resultRepo,
                                         TransferRuleRepository ruleRepo,
                                         CourseContentTopicService topicService) {
        this.resultRepo = resultRepo;
        this.ruleRepo = ruleRepo;
        this.topicService = topicService;
    }

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
        // 1. Fetch Topics
        List<CourseContentTopic> sourceTopics = topicService.getTopicsForCourse(sourceCourseId);
        List<CourseContentTopic> targetTopics = topicService.getTopicsForCourse(targetCourseId);

        if (sourceTopics.isEmpty() || targetTopics.isEmpty()) {
            throw new RuntimeException("Cannot evaluate courses with no content topics");
        }

        Course source = sourceTopics.get(0).getCourse();
        Course target = targetTopics.get(0).getCourse();

        // 2. Fetch Rules between these universities
        List<TransferRule> rules = ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                source.getUniversity().getId(),
                target.getUniversity().getId()
        );

        if (rules.isEmpty()) {
            throw new RuntimeException("No active transfer agreement found between these universities");
        }
        TransferRule rule = rules.get(0); // Assuming one active rule per pair for simplicity

        // 3. Calculate Overlap
        double overlapScore = calculateOverlap(sourceTopics, targetTopics);

        // 4. Determine Eligibility
        boolean eligible = true;
        StringBuilder notes = new StringBuilder();

        // Check 1: Credit Hours
        int creditDiff = Math.abs(source.getCreditHours() - target.getCreditHours());
        if (creditDiff > rule.getCreditHourTolerance()) {
            eligible = false;
            notes.append("Credit hour difference (").append(creditDiff).append(") exceeds tolerance. ");
        }

        // Check 2: Content Overlap
        if (overlapScore < rule.getMinimumOverlapPercentage()) {
            eligible = false;
            notes.append("Content overlap (").append(String.format("%.2f", overlapScore))
                 .append("%) is below minimum (").append(rule.getMinimumOverlapPercentage()).append("%).");
        }

        if (eligible) {
            notes.append("Transfer Eligible.");
        }

        // 5. Save Result
        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setSourceCourse(source);
        result.setTargetCourse(target);
        result.setOverlapPercentage(overlapScore);
        result.setIsEligibleForTransfer(eligible);
        result.setNotes(notes.toString());

        return resultRepo.save(result);
    }

    private double calculateOverlap(List<CourseContentTopic> sourceTopics, List<CourseContentTopic> targetTopics) {
        double totalMatchWeight = 0.0;
        
        // Normalize names for comparison (lowercase, trimmed)
        Set<String> sourceTopicNames = new HashSet<>();
        for (CourseContentTopic t : sourceTopics) {
            sourceTopicNames.add(t.getTopicName().toLowerCase().trim());
        }

        for (CourseContentTopic targetTopic : targetTopics) {
            String name = targetTopic.getTopicName().toLowerCase().trim();
            if (sourceTopicNames.contains(name)) {
                // If the topic exists in both, we add the weight of the TARGET topic
                // (representing how much of the required target course is covered)
                totalMatchWeight += targetTopic.getWeightPercentage();
            }
        }
        
        // Cap at 100.0 just in case
        return Math.min(100.0, totalMatchWeight);
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
        return resultRepo.findBySourceCourseId(courseId);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id).orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }
}