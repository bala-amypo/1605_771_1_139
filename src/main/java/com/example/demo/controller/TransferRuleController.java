package com.example.demo.controller;

import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class TransferRuleController {
    private final TransferRuleService service;

    public TransferRuleController(TransferRuleService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TransferRule> create(@RequestBody TransferRule r) {
        return ResponseEntity.ok(service.createRule(r));
    }

    @GetMapping("/{id}")
    public TransferRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }
}