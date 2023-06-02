{
  "RewardCalculationService": {
    "Methods": {
      "calculateReward": {
        "args": {
          "agencyAccountIds": "List<String>",
          "investmentTrustIds": "List<String>",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "calculateFee": {
        "args": {
          "agencyAccountIds": "List<String>",
          "investmentTrustIds": "List<String>",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "createPaymentHistory": {
        "args": {
          "agencyAccountId": "String",
          "paymentType": "PaymentType",
          "amount": "BigDecimal",
          "date": "LocalDate"
        },
        "returnType": "void"
      },
      "getPaymentHistory": {
        "args": {
          "agencyAccountId": "String"
        },
        "returnType": "List<PaymentHistory>"
      }
    }
  }
}