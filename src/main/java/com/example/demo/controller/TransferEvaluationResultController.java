package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationResultService;

@RestController
@RequestMapping("/transfer-evaluation-results")
public class TransferEvaluationResultController {

    private final TransferEvaluationResultService service;

    public TransferEvaluationResultController(TransferEvaluationResultService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransferEvaluationResult> create(@RequestBody TransferEvaluationResult result) {
        return new ResponseEntity<>(service.create(result), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferEvaluationResult> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TransferEvaluationResult>> getByStudentId(@PathVariable String studentId) {
        return ResponseEntity.ok(service.getByStudentId(studentId));
    }

    @GetMapping
    public ResponseEntity<List<TransferEvaluationResult>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferEvaluationResult> update(
            @PathVariable Long id,
            @RequestBody TransferEvaluationResult result) {
        return ResponseEntity.ok(service.update(id, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
