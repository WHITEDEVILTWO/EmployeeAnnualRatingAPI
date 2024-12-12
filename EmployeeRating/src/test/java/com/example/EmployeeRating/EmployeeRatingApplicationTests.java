package com.example.EmployeeRating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.notNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.controller.PerformanceController;
import com.example.model.ManagerReview;
import com.example.model.SelfReview;
import com.example.repository.PerformanceSummaryRepository;
import com.example.service.PerformanceService;

@SpringBootTest
class EmployeeRatingApplicationTests {


	private PerformanceController performanceController;

	
	private SelfReview selfReview;

	
	private ManagerReview managerReview;

	PerformanceSummaryRepository performanceSummaryRepository;

	

	

	@Test
	void EmployeeID_And_Manager_rating_Test() {
		performanceController = new PerformanceController();
		selfReview  = new SelfReview();
		managerReview = new ManagerReview();

		
		selfReview.setEmployeeId(10L);
		managerReview.setRating(5);
	
	
		assertEquals(5,managerReview.getRating());
		assertEquals(10,selfReview.getEmployeeId());

	}
}