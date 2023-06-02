package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import com.example.demo.entity.*;
import com.example.demo.service.CustomerManagementService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;

@RestController
public class CustomerManagementController {

    @Autowired
    private CustomerManagementService customerManagementService;

    @PostMapping("/user-accounts")
    public UserAccount createUserAccount(@Valid @RequestBody CustomerManagementService.CreateUserAccountRequest requestBody) {
        return customerManagementService.createUserAccount(requestBody);
    }

    @PutMapping("/user-accounts/{id}")
    public UserAccount updateUserAccount(@PathVariable Integer id, @Valid @RequestBody CustomerManagementService.UpdateUserAccountRequest requestBody) {
        return customerManagementService.updateUserAccount(id, requestBody);
    }

    @DeleteMapping("/user-accounts/{id}")
    public void deleteUserAccount(@PathVariable Integer id) {
        customerManagementService.deleteUserAccount(id);
    }

    @GetMapping("/user-accounts")
    public List<UserAccount> getUserAccounts() {
        return customerManagementService.getUserAccounts();
    }

    @PostMapping("/user-accounts/{id}/investment-goals")
    public InvestmentGoal createInvestmentGoal(@PathVariable Integer id, @Valid @RequestBody CustomerManagementService.CreateInvestmentGoalRequest requestBody) {
        return customerManagementService.createInvestmentGoal(id, requestBody);
    }

    @PutMapping("/user-accounts/{id}/investment-goals/{goalId}")
    public InvestmentGoal updateInvestmentGoal(@PathVariable Integer id, @PathVariable Integer goalId, @Valid @RequestBody CustomerManagementService.UpdateInvestmentGoalRequest requestBody) {
        return customerManagementService.updateInvestmentGoal(id, goalId, requestBody);
    }

    @DeleteMapping("/user-accounts/{id}/investment-goals/{goalId}")
    public void deleteInvestmentGoal(@PathVariable Integer id, @PathVariable Integer goalId) {
        customerManagementService.deleteInvestmentGoal(id, goalId);
    }

    @PutMapping("/user-accounts/{id}/risk-tolerance")
    public InvestmentProfile updateRiskTolerance(@PathVariable Integer id, @Valid @RequestBody CustomerManagementService.UpdateRiskToleranceRequest requestBody) {
        return customerManagementService.updateRiskTolerance(id, requestBody);
    }

    @PutMapping("/user-accounts/{id}/portfolio")
    public UserAccount updatePortfolio(@PathVariable Integer id, @Valid @RequestBody CustomerManagementService.UpdatePortfolioRequest requestBody) {
        return customerManagementService.updatePortfolio(id, requestBody);
    }

    @PostMapping("/user-accounts/{id}/notifications")
    public Notification sendNotification(@PathVariable Integer id, @Valid @RequestBody CustomerManagementService.SendNotificationRequest requestBody) {
        return customerManagementService.sendNotification(id, requestBody);
    }

}
