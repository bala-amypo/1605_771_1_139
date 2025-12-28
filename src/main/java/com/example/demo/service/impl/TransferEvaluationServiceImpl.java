package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.service.TransferEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TransferEvaluationResultRepository resultRepository;

    @Override
    public TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId) {

        Course src = courseRepository.findById(sourceCourseId).orElse(null);
        Course tgt = courseRepository.findById(targetCourseId).orElse(null);

        TransferEvaluationResult result = new TransferEvaluationResult();

        if (src == null || tgt == null) {
            result.setEligible(false);
            return result;
        }

        result.setSourceCourse(src);
        result.setTargetCourse(tgt);

        boolean eligible =
                src.isActive() &&
                tgt.isActive() &&
                src.getUniversity().getName()
                        .equalsIgnoreCase(tgt.getUniversity().getName());

        result.setEligible(eligible);

        return resultRepository.save(result);
    }
}