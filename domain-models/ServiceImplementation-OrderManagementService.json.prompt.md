
# Requirements

投資信託の取引システムを作成するための機能要件の詳細なまとめを以下に示します：
販売者側のシステムにおける機能要件を以下にまとめます：

1. プロダクト管理:
   - 販売する投資信託の情報を管理できる
   - 投資信託の詳細情報（運用方針、パフォーマンス履歴、経費率など）を登録できる
   - 投資信託の価格や手数料などの情報を更新できる
   - 新しい投資信託を追加できる

2. 注文管理:
   - ユーザーの投資信託の購入・売却注文を受け付け、処理できる
   - 注文の成立状況を追跡できる
   - 注文履歴を管理できる

3. 顧客管理:
   - ユーザーのアカウント情報を管理できる
   - ユーザーの投資目標やリスク許容度などの情報を保存できる
   - ユーザーのポートフォリオを表示できる
   - ユーザーに対して通知やアラートを送信できる

4. リサーチ情報:
   - 投資信託に関する情報やリサーチレポートを提供できる
   - ユーザーに対して投資アドバイスを提供できる

5. 報告書生成:
   - ユーザーの投資信託の評価額や収益率を計算・生成できる
   - ユーザーに対して定期的な報告書を提供できる
   - 法的な要件に基づいた報告書の生成をサポートできる

6. セキュリティと認証:
   - システムへのアクセスを制限できるセキュリティ機能を提供できる
   - 販売者側のスタッフや代理店のアカウントを管理できる
   - 適切な認証手段（ユーザー名とパスワード、二要素認証など）を実装できる

7. 報酬計算:
   - 販売者への報酬や手数料の計算を行える
   - 販売者への報酬支払いの履歴を管理できる

以上の機能要件は、販売者側のシステムがスムーズに運営され、投資信託の販売と管理が効率的に行われるために必要です。



# System Requirements

- Server Side Framework: Spring Boot (JPA, Web, Batch, Security, Actuator, Lombok, MapStruct, etc.)
- Frontend Framework: React (Chakra-UI, etc.)
- Database: PostgreSQL
- Infrastructure: AWS



# Domain Models


## Entities

- InvestmentTrust
   - id: Integer;
   - name: String;
   - trustDetails: TrustDetails;
   - trustPrice: TrustPrice;
   - trustFee: TrustFee;

- TrustPrice
   - investmentTrustId: Integer;
   - date: Date;
   - price: Double;

- TrustFee
   - investmentTrustId: Integer;
   - feeType: FeeType;
   - feeAmount: Double;

- Order
   - id: Integer;
   - userAccountId: Integer;
   - investmentTrustId: Integer;
   - orderType: OrderType;
   - amount: BigDecimal;
   - orderStatus: Status;
   - createdAt: LocalDateTime;

- OrderStatus
   - orderId: Integer;
   - status: Status;
   - updatedAt: LocalDateTime;

- OrderHistory
   - orderId: Integer;
   - status: Status;
   - timestamp: LocalDateTime;

- UserAccount
   - id: Integer;
   - userInformation: UserInformation;
   - investmentProfile: InvestmentProfile;
   - portfolio: List<Portfolio>;
   - notifications: List<Notification>;

- InvestmentGoal
   - goalType: GoalType;
   - targetAmount: BigDecimal;
   - targetDate: LocalDate;

- RiskTolerance
   - riskLevel: RiskLevel;

- Portfolio
   - investmentTrustId: Integer;
   - quantity: BigDecimal;

- Notification
   - message: String;
   - timestamp: LocalDateTime;

- ResearchReport
   - id: Integer;
   - investmentTrustId: Integer;
   - title: String;
   - content: String;
   - date: Date;

- InvestmentAdvice
   - userAccountId: Integer;
   - researchReportId: Integer;
   - advice: String;

- TrustEvaluation
   - userAccountId: Integer;
   - investmentTrustId: Integer;
   - evaluationAmount: BigDecimal;
   - date: Date;

- ProfitRate
   - userAccountId: Integer;
   - investmentTrustId: Integer;
   - rate: BigDecimal;
   - date: Date;

- PeriodicReport
   - userAccountId: Integer;
   - reportContent: ReportContent;
   - date: Date;

- LegalReport
   - userAccountId: Integer;
   - reportContent: ReportContent;
   - date: Date;

- AccessControl
   - id: Integer;
   - targetType: String;
   - targetId: Integer;
   - permissions: Set<Permissions>;

- StaffAccount
   - id: Integer;
   - name: String;
   - email: String;
   - password: String;
   - role: String;

- AgencyAccount
   - id: Integer;
   - name: String;
   - email: String;
   - password: String;
   - role: String;

- AuthenticationMethod
   - id: Integer;
   - methodType: String;
   - credentials: Credentials;

- Reward
   - id: Integer;
   - agencyAccountId: Integer;
   - investmentTrustId: Integer;
   - rewardAmount: BigDecimal;
   - date: LocalDate;

- Fee
   - id: Integer;
   - agencyAccountId: Integer;
   - investmentTrustId: Integer;
   - feeAmount: BigDecimal;
   - date: LocalDate;

- PaymentHistory
   - id: Integer;
   - agencyAccountId: Integer;
   - paymentType: PaymentType;
   - amount: BigDecimal;
   - date: LocalDate;


## ValueObjects

- TrustDetails
   - investmentObjective: String;
   - investmentStrategy: String;
   - riskFactors: String;

- PerformanceHistory
   - investmentTrustId: String;
   - date: Date;
   - performance: Double;

- ExpenseRatio
   - investmentTrustId: String;
   - date: Date;
   - ratio: Double;

- PurchaseOrder
   - investmentTrustId: String;
   - userAccountId: String;
   - amount: Double;

- SellOrder
   - investmentTrustId: String;
   - userAccountId: String;
   - quantity: Double;

- UserInformation
   - name: String;
   - email: String;
   - address: String;
   - phoneNumber: String;

- InvestmentProfile
   - investmentGoals: List<InvestmentGoal>;
   - riskTolerance: RiskLevel;

- TrustInformation
   - investmentTrustId: String;
   - researchReports: List<ResearchReport>;
   - performanceHistory: List<PerformanceHistory>;
   - expenseRatio: List<ExpenseRatio>;

- ReportContent
   - title: String;
   - content: String;
   - date: Date;

- Credentials
   - username: String;
   - password: String;
   - twoFactorAuthentication: Boolean;

- RewardAmount
   - agencyAccountId: String;
   - investmentTrustId: String;
   - rewardAmount: Double;
   - date: Date;

- FeeAmount
   - agencyAccountId: String;
   - investmentTrustId: String;
   - feeAmount: Double;
   - date: Date;


## Enums

- FeeType : managementFee, redemptionFee, otherFees
- GoalType : retirement, education, homePurchase, otherGoals
- RiskLevel : conservative, moderate, aggressive
- OrderType : purchase, sell
- Status : pending, completed, cancelled, rejected
- PaymentType : reward, fee
- Permissions : view, edit, delete, create



# Base Code

```java
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Service
public class OrderManagementServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Data
    public static class CreateOrderRequest {
        @NotNull
        private Integer userAccountId;
        @NotNull
        private Integer investmentTrustId;
        @NotNull
        private String orderType;
        @NotNull
        private Double amount;
    }
    public Order createOrder(CreateOrderRequest requestBody) {
        // TODO implementation
    }

    @Data
    public static class UpdateOrderStatusRequest {
        @NotNull
        private String status;
    }
    public OrderStatus updateOrderStatus(Integer id, UpdateOrderStatusRequest requestBody) {
        // TODO implementation
    }

    public List<OrderHistory> getOrderHistory(Integer id) {
        // TODO implementation
    }

    public List<Order> getOrdersByUser(Integer id) {
        // TODO implementation
    }

    public List<Order> getOrdersByInvestmentTrust(Integer id) {
        // TODO implementation
    }

}

```



# Instructions

Please understand the contents of Requirements and Domain Models and write the implementation of all methods of Base Code "OrderManagementService".
The target is as follows.
- createOrder, updateOrderStatus, getOrderHistory, getOrdersByUser, getOrdersByInvestmentTrust
The instructions are just guidelines. Please proceed while self-completing the know-how recalled based on the instructions.
- Pay attention to consistency in item names. Pay particular attention to the difference between ID, Id, and id.
- Do not change the signature of the method, but consider only the contents of the method.
- Write the source code that replaces "TODO implementation" in the contents of the method.
- All entities are annotated with @Builder and @Data. Do not use the constructor, use builder().
- Throw all errors with RuntimeException.
- Simulate the test and remove the bug.
- Repeat the iteration several times, perform appropriate refactoring, and output only the completed implementation.
Please refer to Output Example for the output format.



# Output Format

Please output in the following JSON format. It must be a readable JSON format. Strings containing line breaks and double quotes should be output including the line break code after escaping.
```json
{"additionalImports": ["${import}"], "additionalJPAMethods": ["${repository method}"], "methods": {"${methodName}": {"annotations":["${method annotation}"],"body":"${body source code of methods, which replaces \"TODO implementation\" without method signature}"} }}
```



# Output Example

```json
{"additionalImports": ["java.util.List"], "additionalJPAMethods": {"EntityRepository":["List<Entity> findByEntityNameAndEntityLabel(String entityName,String entityLabel)"]}, "methods": {"findAll": {"annotations":["${method annotation}"],"body":"        List<Entity> findAll = this.employeeRepository.findAll();\n        return findAll;"} }}
```

