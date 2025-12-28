package com.example.demo.service.impl;

import com.example.demo.entity.TransferRule;
import com.example.demo.repository.TransferRuleRepository;
import com.example.demo.service.TransferRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferRuleServiceImpl implements TransferRuleService {

    @Autowired
    private TransferRuleRepository transferRuleRepository;

    @Override
    public TransferRule deactivateRule(Long id) {
        TransferRule rule = transferRuleRepository.findById(id).orElse(null);
        if (rule != null) {
            rule.setActive(false); // deactivate
            transferRuleRepository.save(rule);
        }
        return rule;
    }
}
