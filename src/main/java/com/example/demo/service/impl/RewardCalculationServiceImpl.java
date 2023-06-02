package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RewardCalculationService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.example.demo.service.RewardCalculationService.CalculateRewardRequest;
import com.example.demo.service.RewardCalculationService.CalculateFeeRequest;
import com.example.demo.service.RewardCalculationService.CreatePaymentHistoryRequest;

@Service
public class RewardCalculationServiceImpl implements RewardCalculationService {

    @Autowired
    private RewardRepository rewardRepository;

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public RewardAmount calculateReward(CalculateRewardRequest requestBody) {
            Reward reward = rewardRepository.findByAgencyAccountIdAndInvestmentTrustId(requestBody.getAgencyAccountId(), requestBody.getInvestmentTrustId()).orElse(null);
            if (reward == null) {
                reward = Reward.builder()
                        .agencyAccountId(requestBody.getAgencyAccountId())
                        .investmentTrustId(requestBody.getInvestmentTrustId())
                        .rewardAmount(BigDecimal.ZERO)
                        .date(LocalDate.now())
                        .build();
            }
            BigDecimal rewardAmount = BigDecimal.valueOf(requestBody.getInvestmentAmount()).multiply(BigDecimal.valueOf(0.01));
            reward.setRewardAmount(reward.getRewardAmount().add(rewardAmount));
            rewardRepository.save(reward);
            return new RewardAmount(reward.getAgencyAccountId().toString(), reward.getInvestmentTrustId().toString(), reward.getRewardAmount().doubleValue(), reward.getDate());
    }

    @Override
    public FeeAmount calculateFee(CalculateFeeRequest requestBody) {
            Fee fee = feeRepository.findByAgencyAccountIdAndInvestmentTrustId(requestBody.getAgencyAccountId(), requestBody.getInvestmentTrustId()).orElse(null);
            if (fee == null) {
                fee = Fee.builder()
                        .agencyAccountId(requestBody.getAgencyAccountId())
                        .investmentTrustId(requestBody.getInvestmentTrustId())
                        .feeAmount(BigDecimal.ZERO)
                        .date(LocalDate.now())
                        .build();
            }
            BigDecimal feeAmount = BigDecimal.valueOf(requestBody.getInvestmentAmount()).multiply(BigDecimal.valueOf(0.005));
            fee.setFeeAmount(fee.getFeeAmount().add(feeAmount));
            feeRepository.save(fee);
            return new FeeAmount(fee.getAgencyAccountId().toString(), fee.getInvestmentTrustId().toString(), fee.getFeeAmount().doubleValue(), fee.getDate());
    }

    @Override
    public PaymentHistory createPaymentHistory(CreatePaymentHistoryRequest requestBody) {
            PaymentHistory paymentHistory = PaymentHistory.builder()
                    .agencyAccountId(requestBody.getAgencyAccountId())
                    .paymentType(requestBody.getPaymentType())
                    .amount(BigDecimal.valueOf(requestBody.getAmount()))
                    .date(LocalDate.now())
                    .build();
            paymentHistoryRepository.save(paymentHistory);
            return paymentHistory;
    }

    @Override
    public List<PaymentHistory> getPaymentHistory(Integer agencyAccountId) {
            List<PaymentHistory> paymentHistories = paymentHistoryRepository.findByAgencyAccountId(agencyAccountId);
            return paymentHistories;
    }

}
