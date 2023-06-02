{"ProductManagementService": {
  "createInvestmentTrust": {
    "endpoint": "/api/v1/investment-trusts",
    "pathVariable": null,
    "method": "POST",
    "request": "{name:string, trustDetails:TrustDetails, trustPrice:TrustPrice, trustFee:TrustFee}",
    "validation": "{name:[\"@NotBlank\"], trustDetails:[\"@NotNull\"], trustPrice:[\"@NotNull\"], trustFee:[\"@NotNull\"]}",
    "response": "InvestmentTrust",
    "description": "Create a new investment trust"
  },
  "updateInvestmentTrust": {
    "endpoint": "/api/v1/investment-trusts/{id}",
    "pathVariable": "{id:int}",
    "method": "PUT",
    "request": "{name:string, trustDetails:TrustDetails, trustPrice:TrustPrice, trustFee:TrustFee}",
    "validation": "{name:[\"@NotBlank\"], trustDetails:[\"@NotNull\"], trustPrice:[\"@NotNull\"], trustFee:[\"@NotNull\"]}",
    "response": "InvestmentTrust",
    "description": "Update an existing investment trust"
  },
  "deleteInvestmentTrust": {
    "endpoint": "/api/v1/investment-trusts/{id}",
    "pathVariable": "{id:int}",
    "method": "DELETE",
    "request": null,
    "validation": null,
    "response": null,
    "description": "Delete an existing investment trust"
  },
  "getInvestmentTrusts": {
    "endpoint": "/api/v1/investment-trusts",
    "pathVariable": null,
    "method": "GET",
    "request": null,
    "validation": null,
    "response": "InvestmentTrust[]",
    "description": "Get all investment trusts"
  },
  "updateTrustPrice": {
    "endpoint": "/api/v1/investment-trusts/{id}/price",
    "pathVariable": "{id:int}",
    "method": "PUT",
    "request": "{date:Date, price:Double}",
    "validation": "{date:[\"@NotNull\"], price:[\"@NotNull\"]}",
    "response": "TrustPrice",
    "description": "Update the price of an investment trust"
  },
  "updateTrustFee": {
    "endpoint": "/api/v1/investment-trusts/{id}/fee",
    "pathVariable": "{id:int}",
    "method": "PUT",
    "request": "{feeType:FeeType, feeAmount:Double}",
    "validation": "{feeType:[\"@NotNull\"], feeAmount:[\"@NotNull\"]}",
    "response": "TrustFee",
    "description": "Update the fee of an investment trust"
  }
}}