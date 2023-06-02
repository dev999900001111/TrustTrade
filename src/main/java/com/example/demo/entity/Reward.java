package com.example.demo.entity;

import com.example.demo.base.entity.BaseEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
@Entity
@Table(name = "t_reward")
public class Reward extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer agencyAccountId;

    @Column
    private Integer investmentTrustId;

    @Column
    private BigDecimal rewardAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate date;

}
