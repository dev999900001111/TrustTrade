package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.RewardCalculationService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class RewardCalculationController {

    @Autowired
    private RewardCalculationService rewardCalculationService;

    @PostMapping("/rewards")
    public RewardAmount calculateReward(@Valid @RequestBody RewardCalculationService.CalculateRewardRequest requestBody) {
        return rewardCalculationService.calculateReward(requestBody);
    }

    @PostMapping("/fees")
    public FeeAmount calculateFee(@Valid @RequestBody RewardCalculationService.CalculateFeeRequest requestBody) {
        return rewardCalculationService.calculateFee(requestBody);
    }

    @PostMapping("/payment-history")
    public PaymentHistory createPaymentHistory(@Valid @RequestBody RewardCalculationService.CreatePaymentHistoryRequest requestBody) {
        return rewardCalculationService.createPaymentHistory(requestBody);
    }

    @GetMapping("/payment-history/{agencyAccountId}")
    public List<PaymentHistory> getPaymentHistory(@PathVariable Integer agencyAccountId) {
        return rewardCalculationService.getPaymentHistory(agencyAccountId);
    }

}
