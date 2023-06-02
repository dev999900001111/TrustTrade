package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface RewardCalculationService {

    @Data
    public static class CalculateRewardRequest {
        @NotNull
        @Positive
        private Integer agencyAccountId;
        @NotNull
        @Positive
        private Integer investmentTrustId;
        @NotNull
        @Positive
        private Double investmentAmount;
    }
    public RewardAmount calculateReward(CalculateRewardRequest requestBody) ;

    @Data
    public static class CalculateFeeRequest {
        @NotNull
        @Positive
        private Integer agencyAccountId;
        @NotNull
        @Positive
        private Integer investmentTrustId;
        @NotNull
        @Positive
        private Double investmentAmount;
    }
    public FeeAmount calculateFee(CalculateFeeRequest requestBody) ;

    @Data
    public static class CreatePaymentHistoryRequest {
        @NotNull
        @Positive
        private Integer agencyAccountId;
        @NotNull
        private String paymentType;
        @NotNull
        @Positive
        private Double amount;
    }
    public PaymentHistory createPaymentHistory(CreatePaymentHistoryRequest requestBody) ;

    public List<PaymentHistory> getPaymentHistory(Integer agencyAccountId) ;

}
