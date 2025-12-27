package com.example.demo.controller;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/evaluate")
    public ResponseEntity<TransferEvaluationResult> evaluateTransfer(
            @RequestParam Long sourceCourseId,
            @RequestParam Long targetCourseId) {
        return ResponseEntity.ok(evaluationService.evaluateTransfer(sourceCourseId, targetCourseId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TransferEvaluationResult>> getHistory(@PathVariable Long courseId) {
        return ResponseEntity.ok(evaluationService.getEvaluationsForCourse(courseId));
    }
}