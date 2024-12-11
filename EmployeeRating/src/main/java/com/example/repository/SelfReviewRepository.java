package com.example.repository;

import com.example.model.SelfReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfReviewRepository extends JpaRepository<SelfReview,Long> {
    SelfReview findByEmployeeId(Long employeeId);

}
