package com.example.demo.repository;

public interface TransferEvaulationResultRepository extends JpaRepository<TransferEvaulationResult, Long> {
    List<TransferEvaulationResult> findByStudentId(String studentId);
}
