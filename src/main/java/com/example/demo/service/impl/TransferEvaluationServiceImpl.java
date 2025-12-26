package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransferEvaluationServiceImpl {
    @Autowired private CourseRepository courseRepo;
    @Autowired private CourseContentTopicRepository topicRepo;
    @Autowired private TransferRuleRepository ruleRepo;
    @Autowired private TransferEvaluationResultRepository evalRepo;

    public TransferEvaluationResult evaluateTransfer(Long sourceId, Long targetId) {
        Course src = courseRepo.findById(sourceId).orElseThrow(() -> new ResourceNotFoundException("Source course not found"));
        Course tgt = courseRepo.findById(targetId).orElseThrow(() -> new ResourceNotFoundException("Target course not found"));

        if (!src.isActive() || !tgt.isActive()) {
            throw new IllegalArgumentException("inactive course"); // Matches test ex.getMessage()
        }

        List<CourseContentTopic> srcTopics = topicRepo.findByCourseId(sourceId);
        List<CourseContentTopic> tgtTopics = topicRepo.findByCourseId(targetId);
        
        double overlap = calculateOverlap(srcTopics, tgtTopics);
        
        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setOverlapPercentage(overlap);
        return evalRepo.save(result);
    }

    private double calculateOverlap(List<CourseContentTopic> src, List<CourseContentTopic> tgt) {
        double match = 0;
        for (CourseContentTopic s : src) {
            for (CourseContentTopic t : tgt) {
                if (s.getTopicName().equalsIgnoreCase(t.getTopicName())) {
                    match += s.getWeightPercentage();
                }
            }
        }
        return match;
    }
}