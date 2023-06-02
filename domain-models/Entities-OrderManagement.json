{
  "Order": {
    "Attributes": {
      "id": "Long",
      "userAccountId": "Long",
      "investmentTrustId": "Long",
      "orderType": "OrderType",
      "amount": "BigDecimal",
      "orderStatus": "Status",
      "createdAt": "LocalDateTime"
    },
    "Methods": {
      "updateOrderStatus": {
        "args": {
          "status": "Status"
        },
        "returnType": "void"
      },
      "getOrderHistory": {
        "args": {},
        "returnType": "List<OrderHistory>"
      },
      "getOrdersByUser": {
        "args": {
          "userAccountId": "Long"
        },
        "returnType": "List<Order>"
      },
      "getOrdersByInvestmentTrust": {
        "args": {
          "investmentTrustId": "Long"
        },
        "returnType": "List<Order>"
      }
    }
  },
  "OrderStatus": {
    "Attributes": {
      "orderId": "Long",
      "status": "Status",
      "updatedAt": "LocalDateTime"
    },
    "Methods": {}
  },
  "OrderHistory": {
    "Attributes": {
      "orderId": "Long",
      "status": "Status",
      "timestamp": "LocalDateTime"
    },
    "Methods": {}
  }
}