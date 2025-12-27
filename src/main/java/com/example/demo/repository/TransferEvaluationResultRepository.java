package com.example.demo.repository;
import com.example.demo.entity.TransferEvaluationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RuleRepository extends JpaRepository<TransferRule, Long> {
    List<TransferRule> findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(Long sourceId, Long targetId);
}