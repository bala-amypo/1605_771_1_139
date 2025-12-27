package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.service.TransferEvaluationService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired private CourseRepository courseRepo;
    @Autowired private CourseContentTopicRepository topicRepo;
    @Autowired private TransferRuleRepository ruleRepo;
    @Autowired private TransferEvaluationResultRepository evaluationRepo;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {
        Course src = courseRepo.findById(sourceCourseId).orElseThrow(() -> new ResourceNotFoundException("Source course not found"));
        Course tgt = courseRepo.findById(targetCourseId).orElseThrow(() -> new ResourceNotFoundException("Target course not found"));

        if (!src.isActive() || !tgt.isActive()) {
            throw new IllegalArgumentException("Both courses must be active");
        }

        // 1. Find active rule
        Optional<TransferRule> ruleOpt = ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                src.getUniversity().getId(), tgt.getUniversity().getId()).stream().findFirst();

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setSourceCourse(src);
        result.setTargetCourse(tgt);
        result.setEvaluatedAt(LocalDateTime.now());
        
        int creditDiff = Math.abs(src.getCreditHours() - tgt.getCreditHours());
        result.setCreditHourDifference(creditDiff);

        if (ruleOpt.isEmpty()) {
            result.setIsEligibleForTransfer(false);
            result.setOverlapPercentage(0.0);
            result.setNotes("No active transfer rule");
            return evaluationRepo.save(result);
        }

        TransferRule rule = ruleOpt.get();

        // 2. Calculate Overlap
        List<CourseContentTopic> srcTopics = topicRepo.findByCourseId(sourceCourseId);
        List<CourseContentTopic> tgtTopics = topicRepo.findByCourseId(targetCourseId);

        double totalOverlap = 0.0;
        
        // Simple logic: sum the minimum weight for topics with matching names
        for (CourseContentTopic s : srcTopics) {
            for (CourseContentTopic t : tgtTopics) {
                if (s.getTopicName().trim().equalsIgnoreCase(t.getTopicName().trim())) {
                    // Overlap is the min coverage of the concept
                    totalOverlap += Math.min(s.getWeightPercentage(), t.getWeightPercentage());
                }
            }
        }
        
        // Cap at 100
        if (totalOverlap > 100.0) totalOverlap = 100.0;
        result.setOverlapPercentage(totalOverlap);

        // 3. Evaluate against Rule
        boolean overlapPass = totalOverlap >= rule.getMinimumOverlapPercentage();
        boolean creditPass = creditDiff <= rule.getCreditHourTolerance();

        if (overlapPass && creditPass) {
            result.setIsEligibleForTransfer(true);
            result.setNotes("Eligible for transfer");
        } else {
            result.setIsEligibleForTransfer(false);
            String note = "";
            if (!overlapPass) note += "Insufficient topic overlap. ";
            if (!creditPass) note += "Credit hour difference exceeds tolerance.";
            result.setNotes(note.trim());
        }

        return evaluationRepo.save(result);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return evaluationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evaluation not found"));
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId) {
        return evaluationRepo.findBySourceCourseId(courseId); // Ensure this method exists in your repo
    }
}
    