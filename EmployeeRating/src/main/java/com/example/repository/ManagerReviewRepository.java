package com.example.repository;


import com.example.model.ManagerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerReviewRepository  extends JpaRepository<ManagerReview, Long> {
    ManagerReview findByEmployeeId(Long employeeId);
}
