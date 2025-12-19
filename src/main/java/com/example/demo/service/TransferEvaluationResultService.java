package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationResultService {
    TransferEvaluationResult create(TransferEvaluationResult result);
    TransferEvaluationResult getById(Long id);
    List<TransferEvaluationResult> getByStudentId(String studentId);
    List<TransferEvaluationResult> getAll();
    TransferEvaluationResult update(Long id, TransferEvaluationResult result);
    void delete(Long id);
}
