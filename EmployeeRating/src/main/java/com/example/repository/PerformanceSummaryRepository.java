package com.example.repository;

import com.example.model.PerformanceSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceSummaryRepository extends JpaRepository<PerformanceSummary, Long> {
    PerformanceSummary findByEmployeeId(int employeeId);
}
