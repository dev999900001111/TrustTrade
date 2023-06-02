{
  "TrustDetails": {
    "investmentObjective": "String",
    "investmentStrategy": "String",
    "riskFactors": "String"
  },
  "PerformanceHistory": {
    "investmentTrustId": "String",
    "date": "Date",
    "performance": "Double"
  },
  "ExpenseRatio": {
    "investmentTrustId": "String",
    "date": "Date",
    "ratio": "Double"
  },
  "PurchaseOrder": {
    "investmentTrustId": "String",
    "userAccountId": "String",
    "amount": "Double"
  },
  "SellOrder": {
    "investmentTrustId": "String",
    "userAccountId": "String",
    "quantity": "Double"
  },
  "UserInformation": {
    "name": "String",
    "email": "String",
    "address": "String",
    "phoneNumber": "String"
  },
  "InvestmentProfile": {
    "investmentGoals": "List<InvestmentGoal>",
    "riskTolerance": "RiskLevel"
  },
  "TrustInformation": {
    "investmentTrustId": "String",
    "researchReports": "List<ResearchReport>",
    "performanceHistory": "List<PerformanceHistory>",
    "expenseRatio": "List<ExpenseRatio>"
  },
  "ReportContent": {
    "title": "String",
    "content": "String",
    "date": "Date"
  },
  "Credentials": {
    "username": "String",
    "password": "String",
    "twoFactorAuthentication": "Boolean"
  },
  "RewardAmount": {
    "agencyAccountId": "String",
    "investmentTrustId": "String",
    "rewardAmount": "Double",
    "date": "Date"
  },
  "FeeAmount": {
    "agencyAccountId": "String",
    "investmentTrustId": "String",
    "feeAmount": "Double",
    "date": "Date"
  }
}