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
public interface InvestmentTrustRepository extends JpaRepository<InvestmentTrust, Integer> {
    public Optional<InvestmentTrust> findById(Integer id);
    public void deleteById(Integer id);
}
