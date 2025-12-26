package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    private final TransferRuleRepository repo;

    public TransferRuleServiceImpl(TransferRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public TransferRule createRule(TransferRule r) {
        // Validation logic could go here
        return repo.save(r);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule r) {
        TransferRule existing = getRuleById(id);
        existing.setMinimumOverlapPercentage(r.getMinimumOverlapPercentage());
        existing.setCreditHourTolerance(r.getCreditHourTolerance());
        return repo.save(existing);
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(sourceId, targetId);
    }

    @Override
    public void deactivateRule(Long id) {
        TransferRule existing = getRuleById(id);
        existing.setActive(false);
        repo.save(existing);
    }
}