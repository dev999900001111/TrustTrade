{
  "UserAccount": {
    "Attributes": {
      "id": "String",
      "userInformation": "UserInformation",
      "investmentProfile": "InvestmentProfile",
      "portfolio": "List<Portfolio>",
      "notifications": "List<Notification>"
    },
    "Methods": {
      "updateUserAccount": {
        "args": {
          "userInformation": "UserInformation",
          "investmentProfile": "InvestmentProfile",
          "portfolio": "List<Portfolio>",
          "notifications": "List<Notification>"
        },
        "returnType": "void"
      },
      "createInvestmentGoal": {
        "args": {
          "goalType": "GoalType",
          "targetAmount": "BigDecimal",
          "targetDate": "LocalDate"
        },
        "returnType": "void"
      },
      "updateInvestmentGoal": {
        "args": {
          "goalType": "GoalType",
          "targetAmount": "BigDecimal",
          "targetDate": "LocalDate"
        },
        "returnType": "void"
      },
      "deleteInvestmentGoal": {
        "args": {
          "goalType": "GoalType"
        },
        "returnType": "void"
      },
      "updateRiskTolerance": {
        "args": {
          "riskLevel": "RiskLevel"
        },
        "returnType": "void"
      },
      "updatePortfolio": {
        "args": {
          "investmentTrustId": "String",
          "quantity": "BigDecimal"
        },
        "returnType": "void"
      },
      "sendNotification": {
        "args": {
          "message": "String"
        },
        "returnType": "void"
      }
    }
  },
  "UserInformation": {
    "Attributes": {
      "name": "String",
      "email": "String",
      "address": "String",
      "phoneNumber": "String"
    },
    "Methods": {}
  },
  "InvestmentProfile": {
    "Attributes": {
      "investmentGoals": "List<InvestmentGoal>",
      "riskTolerance": "RiskTolerance"
    },
    "Methods": {}
  },
  "InvestmentGoal": {
    "Attributes": {
      "goalType": "GoalType",
      "targetAmount": "BigDecimal",
      "targetDate": "LocalDate"
    },
    "Methods": {}
  },
  "RiskTolerance": {
    "Attributes": {
      "riskLevel": "RiskLevel"
    },
    "Methods": {}
  },
  "Portfolio": {
    "Attributes": {
      "investmentTrustId": "String",
      "quantity": "BigDecimal"
    },
    "Methods": {}
  },
  "Notification": {
    "Attributes": {
      "message": "String",
      "timestamp": "LocalDateTime"
    },
    "Methods": {}
  }
}