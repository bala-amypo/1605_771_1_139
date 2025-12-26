package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferEvaluationResult;

@RestController
@RequestMapping("/api/transfer-evaluations")
@Tag(name = "Transfer Evaluation")
public class TransferEvaluationController {

    @PostMapping("/evaluate/{sourceCourseId}/{targetCourseId}")
    public TransferEvaluation evaluate(@PathVariable Long sourceCourseId,
                                       @PathVariable Long targetCourseId) {
        return null;
    }

    @GetMapping("/{id}")
    public TransferEvaluation getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/course/{courseId}")
    public List<TransferEvaluation> getByCourse(@PathVariable Long courseId) {
        return null;
    }
}
