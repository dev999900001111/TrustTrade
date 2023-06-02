
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

Please extract Aggregates from the domain model.



# Output rules

Please write the type in Java notation.
{"${AggregateName}": {"RootEntity": "${EntityName}","Entities": ["${EntityName}"],"ValueObjects": ["${ValueObjectName}"]}}

