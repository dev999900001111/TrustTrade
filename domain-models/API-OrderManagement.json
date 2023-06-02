{"OrderManagementService": {
  "createOrder": {
    "endpoint": "/api/v1/orders",
    "pathVariable": null,
    "method": "POST",
    "request": "{userAccountId:int, investmentTrustId:int, orderType:string, amount:double}",
    "validation": "{userAccountId:[\"@NotNull\"], investmentTrustId:[\"@NotNull\"], orderType:[\"@NotNull\"], amount:[\"@NotNull\"]}",
    "response": "Order",
    "description": "Create a new order"
  },
  "updateOrderStatus": {
    "endpoint": "/api/v1/orders/{id}/status",
    "pathVariable": "{id:int}",
    "method": "PUT",
    "request": "{status:string}",
    "validation": "{status:[\"@NotNull\"]}",
    "response": "OrderStatus",
    "description": "Update the status of an order"
  },
  "getOrderHistory": {
    "endpoint": "/api/v1/orders/{id}/history",
    "pathVariable": "{id:int}",
    "method": "GET",
    "request": null,
    "validation": null,
    "response": "OrderHistory[]",
    "description": "Get the history of an order"
  },
  "getOrdersByUser": {
    "endpoint": "/api/v1/orders/users/{id}",
    "pathVariable": "{id:int}",
    "method": "GET",
    "request": null,
    "validation": null,
    "response": "Order[]",
    "description": "Get all orders for a user"
  },
  "getOrdersByInvestmentTrust": {
    "endpoint": "/api/v1/orders/investment-trusts/{id}",
    "pathVariable": "{id:int}",
    "method": "GET",
    "request": null,
    "validation": null,
    "response": "Order[]",
    "description": "Get all orders for an investment trust"
  }
}}