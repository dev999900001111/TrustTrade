package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.OrderManagementService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;
import com.example.demo.entity.OrderHistory;
import com.example.demo.repository.OrderHistoryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.example.demo.service.OrderManagementService.CreateOrderRequest;
import com.example.demo.service.OrderManagementService.UpdateOrderStatusRequest;

@Service
public class OrderManagementServiceImpl implements OrderManagementService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public Order createOrder(CreateOrderRequest requestBody) {
            Order order = Order.builder()
                    .userAccountId(requestBody.getUserAccountId())
                    .investmentTrustId(requestBody.getInvestmentTrustId())
                    .orderType(requestBody.getOrderType())
                    .amount(BigDecimal.valueOf(requestBody.getAmount()))
                    .orderStatus(Status.PENDING)
                    .createdAt(LocalDateTime.now())
                    .build();
            return orderRepository.save(order);
    }

    @Override
    public OrderStatus updateOrderStatus(Integer id, UpdateOrderStatusRequest requestBody) {
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Order not found"));
            order.setOrderStatus(Status.valueOf(requestBody.getStatus()));
            orderRepository.save(order);
            OrderStatus orderStatus = OrderStatus.builder()
                    .orderId(id)
                    .status(order.getOrderStatus())
                    .updatedAt(LocalDateTime.now())
                    .build();
            return orderStatusRepository.save(orderStatus);
    }

    @Override
    public List<OrderHistory> getOrderHistory(Integer id) {
            return orderHistoryRepository.findByOrderId(id);
    }

    @Override
    public List<Order> getOrdersByUser(Integer id) {
            return orderRepository.findByUserAccountId(id);
    }

    @Override
    public List<Order> getOrdersByInvestmentTrust(Integer id) {
            return orderRepository.findByInvestmentTrustId(id);
    }

}
