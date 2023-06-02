
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


## Services

- ReportGenerationService: generateTrustEvaluation, generateProfitRate, generatePeriodicReport, generateLegalReport



# Instructions

Based on the Domain Models, create API specifications for ReportGenerationService.
The instructions are just guidelines. Please proceed while self-completing the know-how that is recalled based on the instructions.
- Define the types of Request / Response in detail and accurately. It shouldn't always be the same as the model.
- Do not use objects that are not defined in Domain Models.
- Design the following items.
  Endpoint, Method, Request, Validation, Response, Service.Method, Description
Repeat the iteration several times, perform appropriate refactoring, and output only the completed domain model.
The output format should be JSON only in accordance with the Output Example. Do not output unnecessary items.



# Output Example

```json
{"UserService": {
  "findAll":{"endpoint":"/api/v1/users","pathVariable":null,"method":"GET","request":null,"validation":null,"response":"User[]","description":"Getallusers"},
  "findById":{"endpoint":"/api/v1/users/{id}","pathVariable":"{id:int}","method":"GET","request":null,"validation":null,"response":"User","description":"Getauserbyid"},
  "create":{"endpoint":"/api/v1/users","pathVariable":null,"method":"POST","request":"{name:string,email:string,passowrd:string}","validation":"{name:[\"@NotBlank\"],email:[\"@Email\"],passowrd:[\"@NotBlank\"]}","response":"User","description":"Createauser"},
  "update":{"endpoint":"/api/v1/users/{id}","pathVariable":"{id:int}","method":"PUT","request":"{name:string,email:string,passowrd:string}","validation":"{name:[\"@NotBlank\"],email:[\"@Email\"],passowrd:[\"@NotBlank\"]}","response":"User","description":"Updateauser"},
  "delete":{"endpoint":"/api/v1/users/{id}","pathVariable":"{id:int}","method":"DELETE","request":null,"validation":null,"response":null,"description":"Deleteauser"}
}}
```

