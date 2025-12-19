package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ApiExceptionHandler;
import com.example.demo.repository.TransferEvaluationResultRepository;
import com.example.demo.service.TransferEvaluationResultService;

@Service
public class TransferEvaluationResultServiceImpl implements TransferEvaluationResultService {

    private final TransferEvaluationResultRepository repository;

    public TransferEvaluationResultServiceImpl(TransferEvaluationResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransferEvaluationResult create(TransferEvaluationResult result) {
        if (result.getTotalTransferableCredits() == null || result.getTotalTransferableCredits() < 0) {
            throw new ValidationException("invalid transferable credits");
        }
        return repository.save(result);
    }

    @Override
    public TransferEvaluationResult getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("result not found"));
    }

    @Override
    public List<TransferEvaluationResult> getByStudentId(String studentId) {
        return repository.findByStudentId(studentId);
    }

    @Override
    public List<TransferEvaluationResult> getAll() {
        return repository.findAll();
    }

    @Override
    public TransferEvaluationResult update(Long id, TransferEvaluationResult result) {
        TransferEvaluationResult existing = getById(id);
        existing.setStudentId(result.getStudentId());
        existing.setTotalTransferableCredits(result.getTotalTransferableCredits());
        existing.setStatus(result.getStatus());
        existing.setRemarks(result.getRemarks());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        TransferEvaluationResult existing = getById(id);
        repository.delete(existing);
    }
}
