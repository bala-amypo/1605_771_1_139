package com.example.demo.repository;

public interface TransferEvaulationResultRepository extends JpaRepository<TransferRequest, Long> {
    List<TransferRequest> findByStudentId(String studentId);
}
