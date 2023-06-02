{
  "OrderManagement": {
    "Methods": {
      "createOrder": {
        "args": {
          "investmentTrustId": "String",
          "userAccountId": "String",
          "orderType": "OrderType",
          "amount": "BigDecimal"
        },
        "returnType": "Order"
      },
      "updateOrderStatus": {
        "args": {
          "orderId": "String",
          "status": "Status"
        },
        "returnType": "OrderStatus"
      },
      "getOrderHistory": {
        "args": {
          "orderId": "String"
        },
        "returnType": "List<OrderHistory>"
      },
      "getOrdersByUser": {
        "args": {
          "userAccountId": "String"
        },
        "returnType": "List<Order>"
      },
      "getOrdersByInvestmentTrust": {
        "args": {
          "investmentTrustId": "String"
        },
        "returnType": "List<Order>"
      }
    }
  }
}