package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.TransferRule;
import com.example.demo.entity.University;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.repository.UniversityRepository;

public class TransferRuleServiceImpl {

    private TransferRuleRepository repo;
    private UniversityRepository univRepo;

    public TransferRule createRule(TransferRule r) {

        if (r.getMinimumOverlapPercentage() == null ||
            r.getMinimumOverlapPercentage() < 0 ||
            r.getMinimumOverlapPercentage() > 100)
            throw new IllegalArgumentException("Overlap must be 0-100");

        if (r.getCreditHourTolerance() != null &&
            r.getCreditHourTolerance() < 0)
            throw new IllegalArgumentException("Credit tolerance >= 0");

        University s = univRepo.findById(r.getSourceUniversity().getId())
                .orElseThrow(() -> new RuntimeException("not found"));
        University t = univRepo.findById(r.getTargetUniversity().getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        r.setSourceUniversity(s);
        r.setTargetUniversity(t);

        return repo.save(r);
    }

    public TransferRule updateRule(Long id, TransferRule r) {
        TransferRule existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        existing.setMinimumOverlapPercentage(r.getMinimumOverlapPercentage());
        existing.setCreditHourTolerance(r.getCreditHourTolerance());
        return repo.save(existing);
    }

    public TransferRule getRuleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<TransferRule> getRulesForUniversities(Long s, Long t) {
        return repo.findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(s, t);
    }

    public void deactivateRule(Long id) {
        TransferRule r = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        r.setActive(false);
        repo.save(r);
    }
}
