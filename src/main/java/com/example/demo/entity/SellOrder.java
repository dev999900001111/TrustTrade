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
public class SellOrder {

    @Column(name="sell_order_investment_trust_id")
    private String investmentTrustId;

    @Column(name="sell_order_user_account_id")
    private String userAccountId;

    @Column(name="sell_order_quantity")
    private Double quantity;

}
