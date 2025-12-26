package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.TransferEvaluationResult;

public interface TransferEvaluationResultRepository {

    Optional<TransferEvaluationResult> findById(Long id);

    List<TransferEvaluationResult> findBySourceCourseId(Long sourceCourseId);

    TransferEvaluationResult save(TransferEvaluationResult result);
}
