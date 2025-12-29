package com.example.demo.service;

import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationService {

    TransferEvaluationResult evaluateTransfer(
            Long sourceUniversityId,
            Long targetUniversityId,
            Long sourceCourseId,
            Long targetCourseId
    );
}
