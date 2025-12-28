package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer-rules")
public class TransferRuleController {

    @Autowired
    private TransferRuleService transferRuleService;

    // Create a new transfer rule
    @PostMapping
    public ResponseEntity<TransferRule> createRule(@RequestBody TransferRule rule) {
        TransferRule created = transferRuleService.createRule(rule);
        return ResponseEntity.ok(created);
    }

    // Get all transfer rules
    @GetMapping
    public ResponseEntity<List<TransferRule>> getAllRules() {
        List<TransferRule> list = transferRuleService.getAllRules();
        return ResponseEntity.ok(list);
    }

    // Get a transfer rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<TransferRule> getRuleById(@PathVariable Long id) {
        TransferRule rule = transferRuleService.getRuleById(id);
        if (rule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rule);
    }

    // Update a transfer rule
    @PutMapping("/{id}")
    public ResponseEntity<TransferRule> updateRule(@PathVariable Long id, @RequestBody TransferRule rule) {
        TransferRule updated = transferRuleService.updateRule(id, rule);
        return ResponseEntity.ok(updated);
    }

    // Delete a transfer rule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        transferRuleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }

    // Deactivate a transfer rule
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<TransferRule> deactivateRule(@PathVariable Long id) {
        TransferRule deactivated = transferRuleService.deactivateRule(id);
        if (deactivated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deactivated);
    }
}
