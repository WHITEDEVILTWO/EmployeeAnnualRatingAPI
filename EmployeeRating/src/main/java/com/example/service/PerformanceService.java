package com.example.service;

import com.example.model.ManagerReview;
import com.example.model.PerformanceSummary;
import com.example.repository.ManagerReviewRepository;
import com.example.repository.PerformanceSummaryRepository;
import com.example.repository.SelfReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.SelfReview;

import java.time.LocalDateTime;


@Service
public class PerformanceService {

    @Autowired
    private final SelfReviewRepository selfReviewRepository;

    @Autowired
    public PerformanceService(SelfReviewRepository selfReviewRepository) {
        this.selfReviewRepository = selfReviewRepository;
    }

    @Autowired
    private ManagerReviewRepository managerReviewRepository;

    @Autowired
    private PerformanceSummaryRepository performanceSummaryRepository;

  public PerformanceSummary getPerformanceSummary(Long employeeId) {


        SelfReview selfReview = selfReviewRepository.findByEmployeeId(employeeId);

           ManagerReview managerReview = managerReviewRepository.findByEmployeeId(employeeId);
//
        if (selfReview == null || managerReview == null) {
            throw new RuntimeException("Reviews not found for employee ID: " + employeeId);
        }
//  calculating weight to managers rating scale up to 1.
      double rating =managerReview.getRating();
        //System.out.println("Rating "+ rating);
        double weight= rating/5;

        double selfReviewScore = calculateSelfReviewScore(selfReview.getReviewText());

        //calculating Performance score according  the business logic and 
        double performanceScore = Math.min((selfReviewScore+(managerReview.getRating()*weight))/2,5);
//
       PerformanceSummary performanceSummary = new PerformanceSummary();
        performanceSummary.setEmployeeId(employeeId);
        performanceSummary.setSelfReviewText(selfReview.getReviewText());
        performanceSummary.setSelfReviewTimestamp(selfReview.getTimestamp());
        performanceSummary.setManagerReviewText(managerReview.getReviewText());
        performanceSummary.setManagerRating(managerReview.getRating());
        performanceSummary.setManagerReviewTimestamp(managerReview.getTimestamp());
        performanceSummary.setPerformanceScore(performanceScore);
////
       return performanceSummaryRepository.save(performanceSummary);
   }
//calculating self review score based on the employee review comments, scaling up to 5.
    private double calculateSelfReviewScore(String reviewText) {
        return Math.min(reviewText.length() / 50.0, 5.0); // Scale to a max of 5
    }

    public SelfReview saveSelfReview(SelfReview selfReview) {
       selfReview.setTimestamp(LocalDateTime.now());
        return selfReviewRepository.save(selfReview);
    }

    public ManagerReview saveManagerReview(ManagerReview managerReview) {
        managerReview.setTimestamp(LocalDateTime.now());

        return managerReviewRepository.save(managerReview);
    }
}
