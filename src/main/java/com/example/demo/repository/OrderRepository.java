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
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findByUserAccountId(Integer id);

    public List<Order> findByInvestmentTrustId(Integer id);

}
