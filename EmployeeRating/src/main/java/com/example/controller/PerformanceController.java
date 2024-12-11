package com.example.controller;

import com.example.model.ManagerReview;
import com.example.model.PerformanceSummary;
import com.example.model.SelfReview;
import com.example.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class PerformanceController {
    
    @Autowired
    private PerformanceService performanceService;


    @PostMapping("/self")
    public ResponseEntity<SelfReview> addSelfReview(@RequestBody SelfReview selfReview) {
        //PerformanceService performanceService = new PerformanceService();
        SelfReview savedSelfReview = performanceService.saveSelfReview(selfReview);
        return ResponseEntity.ok(savedSelfReview);
    }

//    @GetMapping("/hi")
//    public String getMethodName(){
//        return "Hello";
//    }


    @PostMapping("/manager")
    public ResponseEntity<ManagerReview> addManagerReview(@RequestBody ManagerReview managerReview) {
        ManagerReview savedManagerReview = performanceService.saveManagerReview(managerReview);
        return ResponseEntity.ok(savedManagerReview);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<PerformanceSummary> getPerformanceSummary(@PathVariable Long employeeId) {
        PerformanceSummary summary = performanceService.getPerformanceSummary(employeeId);
        return ResponseEntity.ok(summary);
    }

}
