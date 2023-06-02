package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.CustomerManagementService;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.InvestmentGoal;
import com.example.demo.entity.RiskTolerance;
import com.example.demo.entity.Portfolio;
import com.example.demo.entity.Notification;
import com.example.demo.entity.TrustEvaluation;
import com.example.demo.entity.ProfitRate;
import com.example.demo.entity.PeriodicReport;
import com.example.demo.entity.LegalReport;
import com.example.demo.entity.AccessControl;
import com.example.demo.entity.StaffAccount;
import com.example.demo.entity.AgencyAccount;
import com.example.demo.entity.AuthenticationMethod;
import com.example.demo.entity.Reward;
import com.example.demo.entity.Fee;
import com.example.demo.entity.PaymentHistory;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.InvestmentGoalRepository;
import com.example.demo.repository.RiskToleranceRepository;
import com.example.demo.repository.PortfolioRepository;
import com.example.demo.repository.NotificationRepository;
import com.example.demo.repository.TrustEvaluationRepository;
import com.example.demo.repository.ProfitRateRepository;
import com.example.demo.repository.PeriodicReportRepository;
import com.example.demo.repository.LegalReportRepository;
import com.example.demo.repository.AccessControlRepository;
import com.example.demo.repository.StaffAccountRepository;
import com.example.demo.repository.AgencyAccountRepository;
import com.example.demo.repository.AuthenticationMethodRepository;
import com.example.demo.repository.RewardRepository;
import com.example.demo.repository.FeeRepository;
import com.example.demo.repository.PaymentHistoryRepository;
import com.example.demo.service.CustomerManagementService.CreateUserAccountRequest;
import com.example.demo.service.CustomerManagementService.UpdateUserAccountRequest;
import com.example.demo.service.CustomerManagementService.CreateInvestmentGoalRequest;
import com.example.demo.service.CustomerManagementService.UpdateInvestmentGoalRequest;
import com.example.demo.service.CustomerManagementService.UpdateRiskToleranceRequest;
import com.example.demo.service.CustomerManagementService.UpdatePortfolioRequest;
import com.example.demo.service.CustomerManagementService.SendNotificationRequest;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private InvestmentGoalRepository investmentGoalRepository;

    @Autowired
    private RiskToleranceRepository riskToleranceRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public UserAccount createUserAccount(CreateUserAccountRequest requestBody) {
            UserAccount userAccount = UserAccount.builder()
                    .userInformation(requestBody.getUserInformation())
                    .investmentProfile(requestBody.getInvestmentProfile())
                    .build();
            return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount updateUserAccount(Integer id, UpdateUserAccountRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            userAccount.setUserInformation(requestBody.getUserInformation());
            userAccount.setInvestmentProfile(requestBody.getInvestmentProfile());
            return userAccountRepository.save(userAccount);
    }

    @Override
    public void deleteUserAccount(Integer id) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            userAccountRepository.delete(userAccount);
    }

    @Override
    public List<UserAccount> getUserAccounts() {
            return userAccountRepository.findAll();
    }

    @Override
    public InvestmentGoal createInvestmentGoal(Integer id, CreateInvestmentGoalRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            InvestmentGoal investmentGoal = InvestmentGoal.builder()
                    .goalType(requestBody.getGoalType())
                    .targetAmount(requestBody.getTargetAmount())
                    .targetDate(requestBody.getTargetDate())
                    .build();
            userAccount.getInvestmentProfile().getInvestmentGoals().add(investmentGoal);
            investmentGoalRepository.save(investmentGoal);
            return investmentGoal;
    }

    @Override
    public InvestmentGoal updateInvestmentGoal(Integer id, Integer goalId, UpdateInvestmentGoalRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            InvestmentGoal investmentGoal = userAccount.getInvestmentProfile().getInvestmentGoals().stream()
                    .filter(goal -> goal.getId().equals(goalId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Investment goal not found"));
            investmentGoal.setGoalType(requestBody.getGoalType());
            investmentGoal.setTargetAmount(requestBody.getTargetAmount());
            investmentGoal.setTargetDate(requestBody.getTargetDate());
            return investmentGoalRepository.save(investmentGoal);
    }

    @Override
    public void deleteInvestmentGoal(Integer id, Integer goalId) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            InvestmentGoal investmentGoal = userAccount.getInvestmentProfile().getInvestmentGoals().stream()
                    .filter(goal -> goal.getId().equals(goalId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Investment goal not found"));
            userAccount.getInvestmentProfile().getInvestmentGoals().remove(investmentGoal);
            investmentGoalRepository.delete(investmentGoal);
    }

    @Override
    public InvestmentProfile updateRiskTolerance(Integer id, UpdateRiskToleranceRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            userAccount.getInvestmentProfile().setRiskTolerance(requestBody.getRiskLevel());
            return userAccount.getInvestmentProfile();
    }

    @Override
    public UserAccount updatePortfolio(Integer id, UpdatePortfolioRequest requestBody) {
            UserAccount userAccount = userAccountRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User account not found"));
            portfolioRepository.deleteAllByUserAccountId(id);
            List<Portfolio> portfolioList = requestBody.getPortfolio();
            portfolioList.forEach(portfolio -> {
                portfolio.setUserAccount(userAccount);
                portfolioRepository.save(portfolio);
            });
            userAccount.setPortfolio(portfolioList);
            return user;
    
    }

    @Override
    public Notification sendNotification(Integer id, SendNotificationRequest requestBody) {
    
    }

}
