package com.example.demo.repository;
import com.example.demo.entity.TransferRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RuleRepository extends JpaRepository<TransferRule, Long> {
    // Used in Test 26 and Test 58 (The Long Name)
    List<TransferRule> findBySourceUniversityIdAndTargetUniversityIdAndActiveTrue(Long sourceId, Long targetId);
    
    // Used in Service Impl
    List<TransferRule> findBySourceUniversityIdAndTargetUniversityId(Long sourceId, Long targetId);
}