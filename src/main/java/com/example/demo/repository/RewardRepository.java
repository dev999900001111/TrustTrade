package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {
    public List<Reward> findByAgencyAccountIdAndInvestmentTrustId(Integer agencyAccountId, Integer investmentTrustId);
}
