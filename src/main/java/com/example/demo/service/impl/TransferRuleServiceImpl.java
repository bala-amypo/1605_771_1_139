package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class TransferRuleServiceImpl {

    public TransferRuleRepository repo;
    public UniversityRepository univRepo;

    public TransferRule createRule(TransferRule r) {
        if (r.getMinimumOverlapPercentage() < 0 || r.getMinimumOverlapPercentage() > 100)
            throw new IllegalArgumentException("0-100");
        if (r.getCreditHourTolerance() != null && r.getCreditHourTolerance() < 0)
            throw new IllegalArgumentException(">= 0");

        univRepo.findById(r.getSourceUniversity().getId()).orElseThrow();
        univRepo.findById(r.getTargetUniversity().getId()).orElseThrow();

        return repo.save(r);
    }

    public void deactivateRule(Long id) {
        TransferRule r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        r.setActive(false);
        repo.save(r);
    }

    public TransferRule updateRule(Long id, TransferRule r) {
        TransferRule ex = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return repo.save(ex);
    }

    public TransferRule getRuleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<TransferRule> getRulesForUniversities(Long s, Long t) {
        return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(s, t);
    }
}
