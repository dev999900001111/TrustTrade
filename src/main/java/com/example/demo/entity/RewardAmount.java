package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.math.BigDecimal;
import java.util.List;
import java.time.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class RewardAmount {

    @Column(name="reward_amount_agency_account_id")
    private String agencyAccountId;

    @Column(name="reward_amount_investment_trust_id")
    private String investmentTrustId;

    @Column(name="reward_amount_reward_amount")
    private Double rewardAmount;

    @Column(name="reward_amount_date",columnDefinition = "DATE")
    private LocalDate date;

}
