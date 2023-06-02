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