package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.OrderManagementService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @PostMapping("/orders")
    public Order createOrder(@Valid @RequestBody OrderManagementService.CreateOrderRequest requestBody) {
        return orderManagementService.createOrder(requestBody);
    }

    @PutMapping("/orders/{id}/status")
    public OrderStatus updateOrderStatus(@PathVariable Integer id, @Valid @RequestBody OrderManagementService.UpdateOrderStatusRequest requestBody) {
        return orderManagementService.updateOrderStatus(id, requestBody);
    }

    @GetMapping("/orders/{id}/history")
    public List<OrderHistory> getOrderHistory(@PathVariable Integer id) {
        return orderManagementService.getOrderHistory(id);
    }

    @GetMapping("/orders/users/{id}")
    public List<Order> getOrdersByUser(@PathVariable Integer id) {
        return orderManagementService.getOrdersByUser(id);
    }

    @GetMapping("/orders/investment-trusts/{id}")
    public List<Order> getOrdersByInvestmentTrust(@PathVariable Integer id) {
        return orderManagementService.getOrdersByInvestmentTrust(id);
    }

}
