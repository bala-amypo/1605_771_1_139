package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.TransferRule;

public interface TransferRuleRepository {

    Optional<TransferRule> findById(Long id);

    List<TransferRule> findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(
            Long sourceUniversityId,
            Long targetUniversityId
    );

    TransferRule save(TransferRule rule);
}
