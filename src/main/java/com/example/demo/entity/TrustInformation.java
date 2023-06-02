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
public class TrustInformation {

    @Column(name="trust_information_investment_trust_id")
    private String investmentTrustId;

    @OneToMany
    private List<ResearchReport> researchReports;

    @ElementCollection(fetch = FetchType.LAZY)
    @Embedded
    @JsonUnwrapped
    private List<PerformanceHistory> performanceHistory;

    @ElementCollection(fetch = FetchType.LAZY)
    @Embedded
    @JsonUnwrapped
    private List<ExpenseRatio> expenseRatio;

}
