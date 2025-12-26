package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.CourseContentTopicService;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private TransferEvaluationResultRepository resultRepo;
    
    @Autowired
    private TransferRuleRepository ruleRepo;
    
    @Autowired
    private CourseContentTopicService topicService;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
        List<CourseContentTopic> sourceTopics = topicService.getTopicsForCourse(sourceCourseId);
        List<CourseContentTopic> targetTopics = topicService.getTopicsForCourse(targetCourseId);

        if (sourceTopics.isEmpty() || targetTopics.isEmpty()) {
            throw new RuntimeException("Cannot evaluate courses with no content topics");
        }

        Course source = sourceTopics.get(0).getCourse();
        Course target = targetTopics.get(0).getCourse();

        List<TransferRule> rules = ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                source.getUniversity().getId(),
                target.getUniversity().getId()
        );

        if (rules.isEmpty()) {
            throw new RuntimeException("No active transfer agreement found");
        }
        TransferRule rule = rules.get(0);

        double overlapScore = calculateOverlap(sourceTopics, targetTopics);

        boolean eligible = true;
        StringBuilder notes = new StringBuilder();

        int creditDiff = Math.abs(source.getCreditHours() - target.getCreditHours());
        if (creditDiff > rule.getCreditHourTolerance()) {
            eligible = false;
            notes.append("Credit hour diff ").append(creditDiff).append(" > tolerance. ");
        }

        if (overlapScore < rule.getMinimumOverlapPercentage()) {
            eligible = false;
            notes.append("Overlap ").append(overlapScore).append("% < min ").append(rule.getMinimumOverlapPercentage()).append("%.");
        }

        if (eligible) notes.append("Eligible.");

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
        Set<String> sourceNames = new HashSet<>();
        for (CourseContentTopic t : sourceTopics) sourceNames.add(t.getTopicName().toLowerCase().trim());

        for (CourseContentTopic targetTopic : targetTopics) {
            if (sourceNames.contains(targetTopic.getTopicName().toLowerCase().trim())) {
                totalMatchWeight += targetTopic.getWeightPercentage();
            }
        }
        return Math.min(100.0, totalMatchWeight);
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
        return resultRepo.findBySourceCourseId(courseId);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id).orElse(null);
    }
}