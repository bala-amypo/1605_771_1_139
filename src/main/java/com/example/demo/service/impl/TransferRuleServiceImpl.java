package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    private final TransferRuleRepository ruleRepository;

    public TransferRuleServiceImpl(TransferRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public TransferRule createRule(TransferRule rule) {
        rule.setActive(true);
        return ruleRepository.save(rule);
    }

    @Override
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return ruleRepository
                .findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        sourceId, targetId
                );
    }

    @Override
    public void deactivateRule(Long id) {
        TransferRule rule = ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
        rule.setActive(false);
        ruleRepository.save(rule);
    }
}
