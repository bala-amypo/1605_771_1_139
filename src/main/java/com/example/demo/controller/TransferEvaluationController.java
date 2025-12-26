package com.example.demo.controller;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluate")
public class TransferEvaluationController {
    private final TransferEvaluationService service;

    public TransferEvaluationController(TransferEvaluationService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TransferEvaluationResult> evaluate(@RequestParam Long sourceId, @RequestParam Long targetId) {
        return ResponseEntity.ok(service.evaluateTransfer(sourceId, targetId));
    }
}