{
  "InvestmentTrust": {
    "Attributes": {
      "id": "Long",
      "name": "String",
      "trustDetails": "TrustDetails",
      "trustPrice": "TrustPrice",
      "trustFee": "TrustFee"
    },
    "Methods": {
      "updateTrustPrice": {
        "args": {
          "newPrice": "Double",
          "date": "Date"
        },
        "returnType": "void"
      },
      "updateTrustFee": {
        "args": {
          "feeType": "FeeType",
          "feeAmount": "Double"
        },
        "returnType": "void"
      }
    }
  },
  "TrustPrice": {
    "Attributes": {
      "investmentTrustId": "Long",
      "date": "Date",
      "price": "Double"
    },
    "Methods": {}
  },
  "TrustFee": {
    "Attributes": {
      "investmentTrustId": "Long",
      "feeType": "FeeType",
      "feeAmount": "Double"
    },
    "Methods": {}
  },
  "TrustDetails": {
    "Attributes": {
      "investmentObjective": "String",
      "investmentStrategy": "String",
      "riskFactors": "String"
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