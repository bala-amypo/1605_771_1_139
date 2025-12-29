package com.example.demo.service.impl;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;

import org.springframework.stereotype.Service;

@Service
public class TransferEvaluationServiceImpl implements TransferEvaluationService {

    @Override
    public TransferEvaluationResult evaluateTransfer(
            Long sourceUniversityId,
            Long targetUniversityId,
            Long sourceCourseId,
            Long targetCourseId) {

        TransferEvaluationResult result = new TransferEvaluationResult();
        result.setOverlapPercentage(80.0);
        result.setEligible(true);
        return result;
    }
}
