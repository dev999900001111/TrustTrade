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
public class ExpenseRatio {

    @Column(name="expense_ratio_investment_trust_id")
    private String investmentTrustId;

    @Column(name="expense_ratio_date",columnDefinition = "DATE")
    private LocalDate date;

    @Column(name="expense_ratio_ratio")
    private Double ratio;

}
