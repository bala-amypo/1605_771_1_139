package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferRule;

public interface TransferRuleService {
    TransferRule create(TransferRule rule);
    TransferRule getById(Long id);
    List<TransferRule> getAll();
    TransferRule update(Long id, TransferRule rule);
    void delete(Long id);
}
