package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferEvaluationResult;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/transfer-evaluations")
@Tag(name = "Transfer Evaluation")
public class TransferEvaluationController {

    @PostMapping("/evaluate/{sourceCourseId}/{targetCourseId}")
    public TransferEvaluationResult evaluate(@PathVariable Long sourceCourseId,
                                             @PathVariable Long targetCourseId) {
        return null;
    }

    @GetMapping("/{id}")
    public TransferEvaluationResult getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/course/{courseId}")
    public List<TransferEvaluationResult> getByCourse(@PathVariable Long courseId) {
        return null;
    }
}
