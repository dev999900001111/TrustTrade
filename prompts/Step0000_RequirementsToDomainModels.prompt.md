
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



# Instructions

Please create a domain model step by step according to the following instructions. The instructions are just guidelines. Please proceed while self-completing the points that are recalled based on the instructions.
   1. **Domain Analysis**: The first step in DDD is to understand the problem domain. This involves working closely with domain experts to understand the business rules, processes, and entities involved in the domain. This step is crucial for developing the Ubiquitous Language, a shared language between developers and domain experts that is used throughout the development process.
   2. **Identify Bounded Contexts**: Once you understand the domain, the next step is to identify the Bounded Contexts. These are logical boundaries within the domain where certain models are valid. Each Bounded Context corresponds to a different part of the system, and they can be developed independently. However, be careful not to split them too much.
   3. **Model-Driven Design**: Within each Bounded Context, you'll use Model-Driven Design to create models that reflect the domain. This involves identifying Entities, Value Objects, Aggregates, and Domain Events. 
      - **Entities** are objects that have a distinct identity.
      - **Value Objects** are objects that are defined by their attributes rather than an identity.
      - **Aggregates** are clusters of Entities and Value Objects that are treated as a single unit.
      - **Domain Events** are significant events that domain experts care about. Please treat only those that cross Bounded Contexts as Domain Events.
   4. **Design Repositories**: Repositories are used to handle the persistence of Aggregates. They provide a way to retrieve, add, and remove Aggregates from the system.
   5. **Design Services**: Services are operations that don't naturally belong to an Entity or Value Object. They encapsulate business logic that doesn't fit within the domain objects.
   6. **Design Factories**: Factories are used to create complex objects or Aggregates. They encapsulate the logic of creating these objects.
   7. **Context Mapping**: Once you've designed the models within each Bounded Context, you'll need to understand how these contexts interact with each other. This is done through Context Mapping, which identifies the relationships between Bounded Contexts.
   8. **Implement Anti-Corruption Layer**: If you have legacy systems or external systems that you need to interact with, you might need to implement an Anti-Corruption Layer. This layer translates between the models in your system and the models in the external system, preventing their models from corrupting yours.
   9. **Business Rules and Constraints**: Document business rules and constraints in the domain model.
   10. **Refactoring**: As you learn more about the domain and the system, you'll likely need to refactor your models and design. This is a normal part of DDD and should be embraced.
Please repeat the steps so far and output only the completed domain model.



# Output rules

Please pay attention to the following points to save as many tokens as possible.
- The delimiter of the item should be a pipe delimiter, and if it is further divided within the pipe delimiter, it should be a comma delimiter.

