package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    private TransferRuleRepository repo;

    @Override
    public TransferRule createRule(TransferRule r) {
        return repo.save(r);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule r) {
        TransferRule existing = getRuleById(id);
        if (existing != null) {
            existing.setMinimumOverlapPercentage(r.getMinimumOverlapPercentage());
            existing.setCreditHourTolerance(r.getCreditHourTolerance());
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(sourceId, targetId);
    }

    @Override
    public void deactivateRule(Long id) {
        TransferRule existing = getRuleById(id);
        if (existing != null) {
            existing.setActive(false);
            repo.save(existing);
        }
    }
}