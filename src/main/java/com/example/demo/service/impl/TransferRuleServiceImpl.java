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
        rule.setActive(true);
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
}
