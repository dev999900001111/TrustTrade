{
    "additionalImports": [
        "java.math.BigDecimal",
        "java.time.LocalDate",
        "java.util.List",
        "com.example.demo.entity.UserAccount",
        "com.example.demo.entity.InvestmentGoal",
        "com.example.demo.entity.RiskTolerance",
        "com.example.demo.entity.Portfolio",
        "com.example.demo.entity.Notification",
        "com.example.demo.entity.TrustEvaluation",
        "com.example.demo.entity.ProfitRate",
        "com.example.demo.entity.PeriodicReport",
        "com.example.demo.entity.LegalReport",
        "com.example.demo.entity.AccessControl",
        "com.example.demo.entity.StaffAccount",
        "com.example.demo.entity.AgencyAccount",
        "com.example.demo.entity.AuthenticationMethod",
        "com.example.demo.entity.Reward",
        "com.example.demo.entity.Fee",
        "com.example.demo.entity.PaymentHistory",
        "com.example.demo.repository.UserAccountRepository",
        "com.example.demo.repository.InvestmentGoalRepository",
        "com.example.demo.repository.RiskToleranceRepository",
        "com.example.demo.repository.PortfolioRepository",
        "com.example.demo.repository.NotificationRepository",
        "com.example.demo.repository.TrustEvaluationRepository",
        "com.example.demo.repository.ProfitRateRepository",
        "com.example.demo.repository.PeriodicReportRepository",
        "com.example.demo.repository.LegalReportRepository",
        "com.example.demo.repository.AccessControlRepository",
        "com.example.demo.repository.StaffAccountRepository",
        "com.example.demo.repository.AgencyAccountRepository",
        "com.example.demo.repository.AuthenticationMethodRepository",
        "com.example.demo.repository.RewardRepository",
        "com.example.demo.repository.FeeRepository",
        "com.example.demo.repository.PaymentHistoryRepository"
    ],
    "additionalJPAMethods": {},
    "methods": {
        "createUserAccount": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = UserAccount.builder()\n                .userInformation(requestBody.getUserInformation())\n                .investmentProfile(requestBody.getInvestmentProfile())\n                .build();\n        return userAccountRepository.save(userAccount);"
        },
        "updateUserAccount": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        userAccount.setUserInformation(requestBody.getUserInformation());\n        userAccount.setInvestmentProfile(requestBody.getInvestmentProfile());\n        return userAccountRepository.save(userAccount);"
        },
        "deleteUserAccount": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        userAccountRepository.delete(userAccount);"
        },
        "getUserAccounts": {
            "annotations": [
                "@Override"
            ],
            "body": "        return userAccountRepository.findAll();"
        },
        "createInvestmentGoal": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        InvestmentGoal investmentGoal = InvestmentGoal.builder()\n                .goalType(requestBody.getGoalType())\n                .targetAmount(requestBody.getTargetAmount())\n                .targetDate(requestBody.getTargetDate())\n                .build();\n        userAccount.getInvestmentProfile().getInvestmentGoals().add(investmentGoal);\n        investmentGoalRepository.save(investmentGoal);\n        return investmentGoal;"
        },
        "updateInvestmentGoal": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        InvestmentGoal investmentGoal = userAccount.getInvestmentProfile().getInvestmentGoals().stream()\n                .filter(goal -> goal.getId().equals(goalId))\n                .findFirst()\n                .orElseThrow(() -> new RuntimeException(\"Investment goal not found\"));\n        investmentGoal.setGoalType(requestBody.getGoalType());\n        investmentGoal.setTargetAmount(requestBody.getTargetAmount());\n        investmentGoal.setTargetDate(requestBody.getTargetDate());\n        return investmentGoalRepository.save(investmentGoal);"
        },
        "deleteInvestmentGoal": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        InvestmentGoal investmentGoal = userAccount.getInvestmentProfile().getInvestmentGoals().stream()\n                .filter(goal -> goal.getId().equals(goalId))\n                .findFirst()\n                .orElseThrow(() -> new RuntimeException(\"Investment goal not found\"));\n        userAccount.getInvestmentProfile().getInvestmentGoals().remove(investmentGoal);\n        investmentGoalRepository.delete(investmentGoal);"
        },
        "updateRiskTolerance": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        userAccount.getInvestmentProfile().setRiskTolerance(requestBody.getRiskLevel());\n        return userAccount.getInvestmentProfile();"
        },
        "updatePortfolio": {
            "annotations": [
                "@Override"
            ],
            "body": "        UserAccount userAccount = userAccountRepository.findById(id)\n                .orElseThrow(() -> new RuntimeException(\"User account not found\"));\n        portfolioRepository.deleteAllByUserAccountId(id);\n        List<Portfolio> portfolioList = requestBody.getPortfolio();\n        portfolioList.forEach(portfolio -> {\n            portfolio.setUserAccount(userAccount);\n            portfolioRepository.save(portfolio);\n        });\n        userAccount.setPortfolio(portfolioList);\n        return user;\n"
        }
    }
}