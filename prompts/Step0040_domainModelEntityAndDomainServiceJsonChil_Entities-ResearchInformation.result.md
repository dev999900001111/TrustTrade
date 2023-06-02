{
  "ResearchReport": {
    "Attributes": {
      "id": "Long",
      "investmentTrustId": "Long",
      "title": "String",
      "content": "String",
      "date": "Date"
    },
    "Methods": {
      "createResearchReport": {
        "args": {
          "investmentTrustId": "Long",
          "title": "String",
          "content": "String",
          "date": "Date"
        },
        "returnType": "void"
      },
      "updateResearchReport": {
        "args": {
          "id": "Long",
          "investmentTrustId": "Long",
          "title": "String",
          "content": "String",
          "date": "Date"
        },
        "returnType": "void"
      },
      "deleteResearchReport": {
        "args": {
          "id": "Long"
        },
        "returnType": "void"
      },
      "getResearchReports": {
        "args": {},
        "returnType": "List<ResearchReport>"
      }
    }
  },
  "InvestmentAdvice": {
    "Attributes": {
      "userAccountId": "Long",
      "researchReportId": "Long",
      "advice": "String"
    },
    "Methods": {
      "provideInvestmentAdvice": {
        "args": {
          "userAccountId": "Long",
          "researchReportId": "Long",
          "advice": "String"
        },
        "returnType": "void"
      }
    }
  },
  "TrustInformation": {
    "Attributes": {
      "investmentTrustId": "Long",
      "researchReports": "List<ResearchReport>",
      "performanceHistory": "List<PerformanceHistory>",
      "expenseRatio": "List<ExpenseRatio>"
    },
    "Methods": {}
  },
  "PerformanceHistory": {
    "Attributes": {
      "investmentTrustId": "Long",
      "date": "Date",
      "performance": "Double"
    },
    "Methods": {}
  },
  "ExpenseRatio": {
    "Attributes": {
      "investmentTrustId": "Long",
      "date": "Date",
      "ratio": "Double"
    },
    "Methods": {}
  }
}