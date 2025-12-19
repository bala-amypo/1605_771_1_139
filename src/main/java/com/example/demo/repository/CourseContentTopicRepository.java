package com.example.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;



public interface CourseContentTopicRepository extends JpaRepository<TransferEvaulationResult, Long> {
    List<TransferEvaulationResult> findByStudentId(String studentId);
}
