package com.example.controller;

import com.example.model.ManagerReview;
import com.example.model.PerformanceSummary;
import com.example.model.SelfReview;
import com.example.service.PerformanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class PerformanceController {
    
    @Autowired
    private PerformanceService performanceService;

     @Operation(summary = "Add Self Review", description = "Submits a self-review for an employee.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Self-review saved successfully",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = SelfReview.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/self")
    public ResponseEntity<SelfReview> addSelfReview(@RequestBody SelfReview selfReview) {
        //PerformanceService performanceService = new PerformanceService();
        SelfReview savedSelfReview = performanceService.saveSelfReview(selfReview);
        return ResponseEntity.ok(savedSelfReview);
    }

    @Operation(summary = "Add Manager Review", description = "Submits a manager's review for an employee.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Manager review saved successfully",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = ManagerReview.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/manager")
    public ResponseEntity<ManagerReview> addManagerReview(@RequestBody ManagerReview managerReview) {
        ManagerReview savedManagerReview = performanceService.saveManagerReview(managerReview);
        return ResponseEntity.ok(savedManagerReview);
    }

    @Operation(summary = "Get Performance Summary", description = "Fetches the performance summary for an employee based on their reviews.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Performance summary retrieved successfully",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = PerformanceSummary.class))),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{employeeId}")
    public ResponseEntity<PerformanceSummary> getPerformanceSummary(@PathVariable Long employeeId) {
        PerformanceSummary summary = performanceService.getPerformanceSummary(employeeId);
        return ResponseEntity.ok(summary);
    }

}
