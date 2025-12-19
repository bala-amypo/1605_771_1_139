package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TransferRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ApiExceptionHandler;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    private final TransferRuleRepository repository;

    public TransferRuleServiceImpl(TransferRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransferRule create(TransferRule rule) {
        if (repository.existsBySourceUniversityIgnoreCaseAndTargetUniversityIgnoreCase(
                rule.getSourceUniversity(), rule.getTargetUniversity())) {
            throw new ValidationException("transfer rule already exists");
        }
        return repository.save(rule);
    }

    @Override
    public TransferRule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("transfer rule not found"));
    }

    @Override
    public List<TransferRule> getAll() {
        return repository.findAll();
    }

    @Override
    public TransferRule update(Long id, TransferRule rule) {
        TransferRule existing = getById(id);
        existing.setSourceUniversity(rule.getSourceUniversity());
        existing.setTargetUniversity(rule.getTargetUniversity());
        existing.setMaxCredits(rule.getMaxCredits());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        TransferRule existing = getById(id);
        repository.delete(existing);
    }
}
