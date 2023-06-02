{"ReportGenerationService": {
  "generateTrustEvaluation": {
    "endpoint": "/api/v1/reports/trust-evaluation",
    "pathVariable": null,
    "method": "POST",
    "request": "{userAccountId:int, investmentTrustId:int, evaluationAmount:double, date:date}",
    "validation": "{userAccountId:[\"@NotNull\"], investmentTrustId:[\"@NotNull\"], evaluationAmount:[\"@NotNull\"], date:[\"@NotNull\"]}",
    "response": "TrustEvaluation",
    "description": "Generate a trust evaluation report for a specific user and investment trust"
  },
  "generateProfitRate": {
    "endpoint": "/api/v1/reports/profit-rate",
    "pathVariable": null,
    "method": "POST",
    "request": "{userAccountId:int, investmentTrustId:int, rate:double, date:date}",
    "validation": "{userAccountId:[\"@NotNull\"], investmentTrustId:[\"@NotNull\"], rate:[\"@NotNull\"], date:[\"@NotNull\"]}",
    "response": "ProfitRate",
    "description": "Generate a profit rate report for a specific user and investment trust"
  },
  "generatePeriodicReport": {
    "endpoint": "/api/v1/reports/periodic-report",
    "pathVariable": null,
    "method": "POST",
    "request": "{userAccountId:int, reportContent:{title:string, content:string, date:date}, date:date}",
    "validation": "{userAccountId:[\"@NotNull\"], reportContent:{title:[\"@NotBlank\"], content:[\"@NotBlank\"], date:[\"@NotNull\"]}, date:[\"@NotNull\"]}",
    "response": "PeriodicReport",
    "description": "Generate a periodic report for a specific user"
  },
  "generateLegalReport": {
    "endpoint": "/api/v1/reports/legal-report",
    "pathVariable": null,
    "method": "POST",
    "request": "{userAccountId:int, reportContent:{title:string, content:string, date:date}, date:date}",
    "validation": "{userAccountId:[\"@NotNull\"], reportContent:{title:[\"@NotBlank\"], content:[\"@NotBlank\"], date:[\"@NotNull\"]}, date:[\"@NotNull\"]}",
    "response": "LegalReport",
    "description": "Generate a legal report for a specific user"
  }
}}