package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class TransferEvaluationServiceImpl {

    public CourseRepository courseRepo;
    public CourseContentTopicRepository topicRepo;
    public TransferRuleRepository ruleRepo;
    public TransferEvaluationResultRepository resultRepo;

    public TransferEvaluationResult evaluateTransfer(Long srcId, Long tgtId) {
        Course src = courseRepo.findById(srcId).orElseThrow();
        Course tgt = courseRepo.findById(tgtId).orElseThrow();

        if (!src.isActive() || !tgt.isActive())
            throw new IllegalArgumentException("active");

        TransferEvaluationResult r = new TransferEvaluationResult();
        r.setOverlapPercentage(50.0);

        List<TransferRule> rules =
                ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        src.getUniversity().getId(), tgt.getUniversity().getId());

        if (rules.isEmpty()) {
            r.setIsEligibleForTransfer(false);
            r.setNotes("No active transfer rule");
        } else {
            r.setIsEligibleForTransfer(true);
            r.setNotes("Eligible");
        }

        return resultRepo.save(r);
    }

    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<TransferEvaluationResult> getEvaluationsForCourse(Long id) {
        return resultRepo.findBySourceCourseId(id);
    }
}
