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