package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationService {

    TransferEvaluationResult evaluateTransfer(Long srcId, Long tgtId);

    TransferEvaluationResult getEvaluationById(Long id);

    List<TransferEvaluationResult> getEvaluationsForCourse(Long id);
}
