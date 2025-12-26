package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationResultService;

@Service
public class TransferEvaluationResultServiceImpl
        implements TransferEvaluationResultService {

    @Override
    public List<TransferEvaluationResult> getAll() {
        return List.of();
    }
}
