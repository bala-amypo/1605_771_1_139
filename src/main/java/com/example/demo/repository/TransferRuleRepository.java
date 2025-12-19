package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.TransferRule;

public interface TransferRuleRepository extends JpaRepository<TransferRule, Long> {
    Optional<TransferRule> findBySourceUniversityIgnoreCaseAndTargetUniversityIgnoreCase(
            String sourceUniversity, String targetUniversity);
    boolean existsBySourceUniversityIgnoreCaseAndTargetUniversityIgnoreCase(
            String sourceUniversity, String targetUniversity);
}
