package com.example.demo.service;
import com.example.demo.entity.TransferEvaluationResult;
import java.util.List;

public interface TransferEvaluationService {
    TransferEvaluationResult evaluateTransfer(Long sourceCourseId, Long targetCourseId);
    List<TransferEvaluationResult> getEvaluationsForCourse(Long courseId);
    TransferEvaluationResult getEvaluationById(Long id);
}