package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.TransferRule;

public interface TransferRuleRepository {
    Optional<TransferRule> findById(Long id);
    List<TransferRule> findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(Long s, Long t);
    TransferRule save(TransferRule r);
}
