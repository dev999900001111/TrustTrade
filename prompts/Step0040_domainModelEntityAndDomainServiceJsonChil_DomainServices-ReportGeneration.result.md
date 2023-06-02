{
  "ReportGenerationService": {
    "Methods": {
      "generateTrustEvaluation": {
        "args": {
          "userAccountId": "String",
          "investmentTrustId": "String",
          "evaluationAmount": "BigDecimal",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "generateProfitRate": {
        "args": {
          "userAccountId": "String",
          "investmentTrustId": "String",
          "rate": "BigDecimal",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "generatePeriodicReport": {
        "args": {
          "userAccountId": "String",
          "reportContent": "ReportContent",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "generateLegalReport": {
        "args": {
          "userAccountId": "String",
          "reportContent": "ReportContent",
          "date": "LocalDate"
        },
        "returnType": "void"
      }
    }
  }
}