package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer-rules")
public class TransferRuleController {

    @Autowired
    private TransferRuleService transferRuleService;

    @PostMapping
    public TransferRule create(@RequestBody TransferRule rule) {
        return transferRuleService.createRule(rule);
    }

    @GetMapping
    public List<TransferRule> getRules(
            @RequestParam Long sourceUniversityId,
            @RequestParam Long targetUniversityId) {

        return transferRuleService
                .getRulesForUniversities(sourceUniversityId, targetUniversityId);
    }
}
