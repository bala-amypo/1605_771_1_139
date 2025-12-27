package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.TransferRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    private TransferRuleRepository ruleRepo;
    
    @Autowired
    private UniversityRepository universityRepo;

    @Override
    public TransferRule createRule(TransferRule rule) {
        if (rule.getMinimumOverlapPercentage() < 0 || rule.getMinimumOverlapPercentage() > 100) {
            throw new IllegalArgumentException("Overlap percentage must be 0-100");
        }
        if (rule.getCreditHourTolerance() < 0) {
            throw new IllegalArgumentException("Tolerance must be >= 0");
        }
        // Ensure universities exist
        universityRepo.findById(rule.getSourceUniversity().getId()).orElseThrow();
        universityRepo.findById(rule.getTargetUniversity().getId()).orElseThrow();
        
        return ruleRepo.save(rule);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        TransferRule existing = getRuleById(id);
        existing.setMinimumOverlapPercentage(rule.getMinimumOverlapPercentage());
        existing.setCreditHourTolerance(rule.getCreditHourTolerance());
        return ruleRepo.save(existing);
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return ruleRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return ruleRepo.findBySourceUniversityIdAndTargetUniversityId(sourceId, targetId);
    }

    @Override
    public void deactivateRule(Long id) {
        TransferRule r = getRuleById(id);
        r.setActive(false);
        ruleRepo.save(r);
    }
}