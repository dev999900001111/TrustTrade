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
public class TrustDetails {

    @Column(name="trust_details_investment_objective")
    private String investmentObjective;

    @Column(name="trust_details_investment_strategy")
    private String investmentStrategy;

    @Column(name="trust_details_risk_factors")
    private String riskFactors;

}
