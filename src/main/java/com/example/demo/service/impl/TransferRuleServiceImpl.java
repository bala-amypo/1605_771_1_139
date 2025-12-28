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
    private TransferRuleRepository transferRuleRepository;

    @Override
    public TransferRule createRule(TransferRule rule) {
        return transferRuleRepository.save(rule);
    }

    @Override
    public TransferRule updateRule(Long id, TransferRule rule) {
        rule.setId(id);
        return transferRuleRepository.save(rule);
    }

    @Override
    public TransferRule getRuleById(Long id) {
        return transferRuleRepository.findById(id).orElse(null);
    }

    @Override
    public List<TransferRule> getAllRules() {
        return transferRuleRepository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        transferRuleRepository.deleteById(id);
    }

    @Override
    public TransferRule deactivateRule(Long id) {
        TransferRule rule = transferRuleRepository.findById(id).orElse(null);
        if (rule != null) {
            rule.setActive(false);
            transferRuleRepository.save(rule);
        }
        return rule;
    }
}
