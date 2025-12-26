package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TransferEvaluationResult;

@RestController
@RequestMapping("/transfer-evaluation")
public class TransferEvaluationController {

    @GetMapping
    public List<TransferEvaluationResult> getAll() {
        return List.of();
    }
}
