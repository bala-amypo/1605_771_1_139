package com.example.demo.controller;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluation")
public class TransferEvaluationController {

    @Autowired
    private TransferEvaluationService evaluationService;

    @GetMapping("/{src}/{tgt}")
    public TransferEvaluationResult evaluate(
            @PathVariable Long src,
            @PathVariable Long tgt) {

        return evaluationService.evaluateTransfer(src, tgt);
    }
}
