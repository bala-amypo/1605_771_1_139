package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.entity.TransferRule;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseContentTopicRepository topicRepo;

    @Autowired
    private TransferRuleRepository ruleRepo;

    @Autowired
    private TransferEvaluationResultRepository resultRepo;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long srcId, Long tgtId) {

        Course src = courseRepo.findById(srcId).orElseThrow();
        Course tgt = courseRepo.findById(tgtId).orElseThrow();

        if (!src.isActive() || !tgt.isActive()) {
            throw new IllegalArgumentException("Course is not active");
        }

        TransferEvaluationResult r = new TransferEvaluationResult();
        r.setSourceCourse(src);
        r.setTargetCourse(tgt);
        r.setOverlapPercentage(50.0);

        List<TransferRule> rules =
                ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        src.getUniversity().getId(),
                        tgt.getUniversity().getId());

        if (rules.isEmpty()) {
            r.setIsEligibleForTransfer(false);
            r.setNotes("No active transfer rule");
        } else {
            r.setIsEligibleForTransfer(true);
            r.setNotes("Eligible");
        }

        return resultRepo.save(r);
    }

    @Override
    public TransferEvaluationResult getEvaluationById(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    @Override
    public List<TransferEvaluationResult> getEvaluationsForCourse(Long id) {
        return resultRepo.findBySourceCourseId(id);
    }
}
