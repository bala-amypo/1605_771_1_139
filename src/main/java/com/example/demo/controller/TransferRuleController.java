package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TransferRule;
import com.example.demo.service.TransferRuleService;

@RestController
@RequestMapping("/api/transfer-rules")
@Tag(name = "Transfer Rule")
public class TransferRuleController {

    @PostMapping
    public TransferRule create(@RequestBody TransferRule rule) {
        return null;
    }

    @PutMapping("/{id}")
    public TransferRule update(@PathVariable Long id,
                               @RequestBody TransferRule rule) {
        return null;
    }

    @GetMapping("/{id}")
    public TransferRule getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/pair/{sourceId}/{targetId}")
    public List<TransferRule> getByPair(@PathVariable Long sourceId,
                                        @PathVariable Long targetId) {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
    }
}
