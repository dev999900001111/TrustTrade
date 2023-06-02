
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

Entities => Attributes
- InvestmentTrust: id, name, trustDetails, trustPrice, trustFee
- TrustPrice: investmentTrustId, date, price
- TrustFee: investmentTrustId, feeType, feeAmount
- Order: id, userAccountId, investmentTrustId, orderType, amount, orderStatus, createdAt
- OrderStatus: orderId, status, updatedAt
- OrderHistory: orderId, status, timestamp
- UserAccount: id, userInformation, investmentProfile, portfolio, notifications
- InvestmentGoal: userAccountId, goalType, targetAmount, targetDate
- RiskTolerance: userAccountId, riskLevel
- Portfolio: userAccountId, investmentTrustId, quantity
- Notification: userAccountId, message, timestamp
- ResearchReport: id, investmentTrustId, title, content, date
- InvestmentAdvice: userAccountId, researchReportId, advice
- TrustEvaluation: userAccountId, investmentTrustId, evaluationAmount, date
- ProfitRate: userAccountId, investmentTrustId, rate, date
- PeriodicReport: userAccountId, reportContent, date
- LegalReport: userAccountId, reportContent, date
- AccessControl: id, targetType, targetId, permissions
- StaffAccount: id, name, email, password, role
- AgencyAccount: id, name, email, password, role
- Reward: id, agencyAccountId, investmentTrustId, rewardAmount, date
- Fee: id, agencyAccountId, investmentTrustId, feeAmount, date
- PaymentHistory: id, agencyAccountId, paymentType, amount, date

Value Objects => Attributes
- TrustDetails: investmentObjective, investmentStrategy, riskFactors
- PerformanceHistory: investmentTrustId, date, performance
- ExpenseRatio: investmentTrustId, date, ratio
- PurchaseOrder: investmentTrustId, userAccountId, amount
- SellOrder: investmentTrustId, userAccountId, quantity
- UserInformation: name, email, address, phoneNumber
- InvestmentProfile: investmentGoals, riskTolerance
- TrustInformation: investmentTrustId, researchReports, performanceHistory, expenseRatio
- ReportContent: title, content, date
- Credentials: username, password, twoFactorAuthentication

Enums => Values
- FeeType: managementFee, redemptionFee, otherFees
- GoalType: retirement, education, homePurchase, otherGoals
- RiskLevel: conservative, moderate, aggressive
- OrderType: purchase, sell
- Status: pending, completed, cancelled, rejected
- PaymentType: reward, fee
- Permissions: view, edit, delete, create

Aggregates => RootEntity, Entities, Value Objects
- InvestmentTrustAggregate: InvestmentTrust, TrustPrice, TrustFee, TrustDetails, PerformanceHistory, ExpenseRatio
- OrderAggregate: Order, OrderStatus, OrderHistory, PurchaseOrder, SellOrder
- UserAccountAggregate: UserAccount, UserInformation, InvestmentGoal, RiskTolerance, Portfolio, Notification, InvestmentProfile
- ResearchReportAggregate: ResearchReport, InvestmentAdvice, TrustInformation
- ReportAggregate: TrustEvaluation, ProfitRate, PeriodicReport, LegalReport, ReportContent
- AuthenticationAggregate: AccessControl, StaffAccount, AgencyAccount, AuthenticationMethod, Credentials
- RewardCalculationAggregate: Reward, Fee, PaymentHistory, RewardAmount, FeeAmount

Domain Services => Methods
- ProductManagementService: createInvestmentTrust, updateInvestmentTrust, deleteInvestmentTrust, getInvestmentTrusts, updateTrustPrice, updateTrustFee
- OrderManagementService: createOrder, updateOrderStatus, getOrderHistory, getOrdersByUser, getOrdersByInvestmentTrust
- CustomerManagementService: createUserAccount, updateUserAccount, deleteUserAccount, getUserAccounts, createInvestmentGoal, updateInvestmentGoal, deleteInvestmentGoal, updateRiskTolerance, updatePortfolio, sendNotification
- ResearchInformationService: createResearchReport, updateResearchReport, deleteResearchReport, getResearchReports, provideInvestmentAdvice
- ReportGenerationService: generateTrustEvaluation, generateProfitRate, generatePeriodicReport, generateLegalReport
- SecurityAndAuthenticationService: createAccessControl, updateAccessControl, deleteAccessControl, createStaffAccount, updateStaffAccount, deleteStaffAccount, createAgencyAccount, updateAgencyAccount, deleteAgencyAccount, authenticateUser
- RewardCalculationService: calculateReward, calculateFee, createPaymentHistory, getPaymentHistory

Domain Events => Attributes, Description
- InvestmentTrustCreated: investmentTrustId, name, trustDetails, trustPrice, trustFee | Triggered when a new investment trust is created
- InvestmentTrustUpdated: investmentTrustId, name, trustDetails, trustPrice, trustFee | Triggered when an investment trust is updated
- OrderPlaced: orderId, userAccountId, investmentTrustId, orderType, amount | Triggered when a new order is placed
- OrderStatusChanged: orderId, orderStatus | Triggered when the status of an order is changed
- UserAccountCreated: userAccountId, userInformation, investmentProfile | Triggered when a new user account is created
- UserAccountUpdated: userAccountId, userInformation, investmentProfile | Triggered when a user account is updated
- ResearchReportCreated: researchReportId, investmentTrustId, title, content, date | Triggered when a new research report is created
- ResearchReportUpdated: researchReportId, investmentTrustId, title, content, date | Triggered when a research report is updated
- ReportGenerated: reportId, userAccountId, reportContent, date | Triggered when a report is generated
- RewardCalculated: rewardId, agencyAccountId, investmentTrustId, rewardAmount, date | Triggered when a reward is calculated
- FeeCalculated: feeId, agencyAccountId, investmentTrustId, feeAmount, date | Triggered when a fee is calculated

Batch Jobs => Methods, Attributes, Description
- updateTrustPrices: investmentTrustIds, newPrices, date | Updates the prices of investment trusts periodically
- generatePeriodicReports: userAccountIds, reportContents, date | Generates periodic reports for users
- calculateRewardsAndFees: agencyAccountIds, investmentTrustIds, rewardAmounts, feeAmounts, date | Calculates rewards and fees for agency accounts periodically

Bounded Contexts => Bounded Context, Entities/Value Objects/Aggregates/Domain Services/Domain Events
- ProductManagement: InvestmentTrust, TrustPrice, TrustFee, TrustDetails, PerformanceHistory, ExpenseRatio, InvestmentTrustAggregate, ProductManagementService, InvestmentTrustCreated, InvestmentTrustUpdated
- OrderManagement: Order, OrderStatus, OrderHistory, PurchaseOrder, SellOrder, OrderAggregate, OrderManagementService, OrderPlaced, OrderStatusChanged
- CustomerManagement: UserAccount, InvestmentGoal, RiskTolerance, Portfolio, Notification, UserInformation, InvestmentProfile, UserAccountAggregate, CustomerManagementService, UserAccountCreated, UserAccountUpdated
- ResearchInformation: ResearchReport, InvestmentAdvice, TrustInformation, ResearchReportAggregate, ResearchInformationService, ResearchReportCreated, ResearchReportUpdated
- ReportGeneration: TrustEvaluation, ProfitRate, PeriodicReport, LegalReport, ReportContent, ReportAggregate, ReportGenerationService, ReportGenerated
- SecurityAndAuthentication: AccessControl, StaffAccount, AgencyAccount, AuthenticationMethod, Credentials, AuthenticationAggregate, SecurityAndAuthenticationService
- RewardCalculation: Reward, Fee, PaymentHistory, RewardAmount, FeeAmount, RewardCalculationAggregate, RewardCalculationService, RewardCalculated, FeeCalculated

Context Mapping => Relationship Type, Source, Target
- Partnership: ProductManagement, OrderManagement
- CustomerSupplier: OrderManagement, CustomerManagement
- Conformist: CustomerManagement, ResearchInformation
- AnticorruptionLayer: ResearchInformation, ReportGeneration
- OpenHostService: ReportGeneration, SecurityAndAuthentication
- PublishedLanguage: SecurityAndAuthentication, RewardCalculation



# Instructions

Please refer to the domain model and extract only the DomainServices of BoundexContext "ProductManagement" and convert it to the following JSON format.
```json
{"${DomainServiceName}": {"Methods": {"${methodName}": {"args": {"${name}": "${type}","${name}": "${type}"},"returnType": "${type}"}}}}
```

