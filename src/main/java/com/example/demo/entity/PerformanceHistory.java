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
public class PerformanceHistory {

    @Column(name="performance_history_investment_trust_id")
    private String investmentTrustId;

    @Column(name="performance_history_date",columnDefinition = "DATE")
    private LocalDate date;

    @Column(name="performance_history_performance")
    private Double performance;

}
