package com.example.demo.service;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public interface CustomerManagementService {

    @Data
    public static class CreateUserAccountRequest {
        private UserInformation userInformation;
        private InvestmentProfile investmentProfile;
    }
    public UserAccount createUserAccount(CreateUserAccountRequest requestBody) ;

    @Data
    public static class UpdateUserAccountRequest {
        private UserInformation userInformation;
        private InvestmentProfile investmentProfile;
    }
    public UserAccount updateUserAccount(Integer id, UpdateUserAccountRequest requestBody) ;

    public void deleteUserAccount(Integer id) ;

    public List<UserAccount> getUserAccounts() ;

    @Data
    public static class CreateInvestmentGoalRequest {
        private GoalType goalType;
        private BigDecimal targetAmount;
        private LocalDate targetDate;
    }
    public InvestmentGoal createInvestmentGoal(Integer id, CreateInvestmentGoalRequest requestBody) ;

    @Data
    public static class UpdateInvestmentGoalRequest {
        private GoalType goalType;
        private BigDecimal targetAmount;
        private LocalDate targetDate;
    }
    public InvestmentGoal updateInvestmentGoal(Integer id, Integer goalId, UpdateInvestmentGoalRequest requestBody) ;

    public void deleteInvestmentGoal(Integer id, Integer goalId) ;

    @Data
    public static class UpdateRiskToleranceRequest {
        private RiskLevel riskLevel;
    }
    public InvestmentProfile updateRiskTolerance(Integer id, UpdateRiskToleranceRequest requestBody) ;

    @Data
    public static class UpdatePortfolioRequest {
        private List<Portfolio> portfolio;
    }
    public UserAccount updatePortfolio(Integer id, UpdatePortfolioRequest requestBody) ;

    @Data
    public static class SendNotificationRequest {
        private String message;
    }
    public Notification sendNotification(Integer id, SendNotificationRequest requestBody) ;

}
