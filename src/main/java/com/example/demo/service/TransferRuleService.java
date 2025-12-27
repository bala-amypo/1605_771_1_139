package com.example.demo.service;
import com.example.demo.entity.TransferRule;
import com.example.demo.repository.RuleRepository;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepo;
    
    @Autowired
    private UniversityRepository universityRepo;

    public TransferRule createRule(TransferRule r) {
        universityRepo.findById(r.getSourceUniversity().getId())
             .orElseThrow(() -> new IllegalArgumentException("Source Uni not found"));
        universityRepo.findById(r.getTargetUniversity().getId())
             .orElseThrow(() -> new IllegalArgumentException("Target Uni not found"));

        if (r.getCreditHourTolerance() < 0) {
            throw new IllegalArgumentException("Tolerance must be >= 0");
        }
        return ruleRepo.save(r);
    }

    public TransferRule updateRule(Long id, TransferRule updated) {
        TransferRule r = ruleRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Rule not found"));
        // update logic here
        return ruleRepo.save(r);
    }
    
    public TransferRule getRuleById(Long id) {
        return ruleRepo.findById(id)
             .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    public void deactivateRule(Long id) {
        TransferRule r = getRuleById(id);
        r.setActive(false);
        ruleRepo.save(r);
    }
    
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return ruleRepo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(sourceId, targetId);
    }
}