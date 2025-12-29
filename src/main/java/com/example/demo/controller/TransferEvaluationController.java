package com.example.demo.controller;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferEvaluationController {

    @Autowired
    private TransferEvaluationService transferService;

    @GetMapping("/evaluate")
    public TransferEvaluationResult evaluate(
            @RequestParam Long sourceUniversityId,
            @RequestParam Long targetUniversityId,
            @RequestParam Long sourceCourseId,
            @RequestParam Long targetCourseId) {

        return transferService.evaluateTransfer(
                sourceUniversityId,
                targetUniversityId,
                sourceCourseId,
                targetCourseId
        );
    }
}
