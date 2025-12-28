package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class TransferRuleController {

    @Autowired
    private TransferRuleService ruleService;

    @PostMapping
    public TransferRule create(@RequestBody TransferRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping
    public List<TransferRule> getAll() {
        return ruleService.getAllRules();
    }
}
