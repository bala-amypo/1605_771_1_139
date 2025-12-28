package com.example.demo.service;

import com.example.demo.entity.TransferRule;
import java.util.List;

public interface TransferRuleService {

    TransferRule createRule(TransferRule rule);

    TransferRule updateRule(Long id, TransferRule rule); // added

    TransferRule getRuleById(Long id);

    List<TransferRule> getAllRules();

    void deleteRule(Long id); // ensure this exists

    TransferRule deactivateRule(Long id); // added
}
