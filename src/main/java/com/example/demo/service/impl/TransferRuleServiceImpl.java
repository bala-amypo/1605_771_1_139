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
    private TransferRuleRepository ruleRepository;

    @Override
    public List<TransferRule> getRulesForUniversities(Long sourceId, Long targetId) {
        return ruleRepository
                .findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
                        sourceId, targetId
                );
    }
}
