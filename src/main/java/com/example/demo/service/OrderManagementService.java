package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface OrderManagementService {

    @Data
    public static class CreateOrderRequest {
        @NotNull
        private Integer userAccountId;
        @NotNull
        private Integer investmentTrustId;
        @NotNull
        private String orderType;
        @NotNull
        private Double amount;
    }
    public Order createOrder(CreateOrderRequest requestBody) ;

    @Data
    public static class UpdateOrderStatusRequest {
        @NotNull
        private String status;
    }
    public OrderStatus updateOrderStatus(Integer id, UpdateOrderStatusRequest requestBody) ;

    public List<OrderHistory> getOrderHistory(Integer id) ;

    public List<Order> getOrdersByUser(Integer id) ;

    public List<Order> getOrdersByInvestmentTrust(Integer id) ;

}
